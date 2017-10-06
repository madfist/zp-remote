package com.madfist.zpremote.controller;

import android.util.SparseArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.madfist.zpremote.Log;

/**
 * Created by akoleszar on 2017.10.02..
 */

public class Connector {
    public interface Callback {
        void onConnected(boolean state);
        void onError(int errorCode);
        void onMessageReceived(String msg);
    }

    private Socket socket = null;
    private Scanner reader;
    private PrintWriter writer;
    private ExecutorService pool = Executors.newCachedThreadPool();
    private static final String TAG = "Connector";
    private volatile boolean listening = false;
    private boolean connected = false;
    private SparseArray<MessageListener> listeners;
    private Map<String, MessageListener> functionListeners;
    private Callback callback;

    public static final int CANNOT_CONNECT = 1;

    public Connector(Callback cb) {
        callback = cb;
        listeners = new SparseArray<>();
        functionListeners = new Hashtable<>();
    }

    public void connect(final String address, final int port) {
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(address, port);
                    listening = true;
                    reader = new Scanner(socket.getInputStream());
                    writer = new PrintWriter(socket.getOutputStream());
                    connected = true;
                    listen();
                    callback.onConnected(true);
                } catch (IOException e) {
                    callback.onError(CANNOT_CONNECT);
                    Log.e(TAG, "connect() failed - " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    public void disconnect() {
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (socket != null && socket.isConnected()) {
                        listening = false;
                        writer.close();
                        reader.close();
                        socket.close();
                        callback.onConnected(false);
                        connected = false;
                    }
                } catch (IOException e) {
                    Log.e(TAG, "disconnect() failed - " + e.getMessage());
                }
            }
        });
    }

    public void listen() {
        if (!connected) {
            return;
        }
        pool.submit(new Runnable() {
            @Override
            public void run() {
                while(listening) {
                    if (reader.hasNextLine()) {
                        String message = reader.nextLine();
//                        Log.d(TAG, "listen(" + message + ")");
                        MessageListener ml;
                        int messageCode = MessageCode.parse(message.substring(0,4));
                        if (MessageCode.isFunction(messageCode)) {
//                            Log.d(TAG, "listen() - function[" + message.substring(4) + "]");
                            ml = functionListeners.get(message.substring(4));
                        } else {
//                            Log.d(TAG, "listen() - command[" + messageCode + "]");
                            ml = listeners.get(messageCode);
                        }
                        if (ml != null) {
                            ml.onMessageReceived(message.substring(5));
                            if (!ml.keep) {
                                if (MessageCode.isFunction(messageCode)) {
                                    functionListeners.remove(message.substring(5));
                                } else {
                                    listeners.remove(messageCode);
                                }
                            }
                        } else {
                            callback.onMessageReceived(message);
                        }
                    }
                }
            }
        });
    }

    public void executeCommand(final int command, MessageListener l, String ... args) {
        if (!connected) {
            return;
        }
        addMessageListener(command, l, args);
        final String arguments = joinString(args);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "executeCommand(" + MessageCode.get(command) + arguments + ")");
                writer.print(MessageCode.get(command) + arguments + "\r\n");
                writer.flush();
            }
        });
    }

    public void addMessageListener(int command, MessageListener l, String ... args) {
        String arguments = null;
        if (args.length > 0) {
            arguments = joinString(args);
        }
//        Log.d(TAG, "addMessageListener(" + command + arguments + ")");
        if (l != null && listeners.get(command) == null) {
            if (arguments != null && MessageCode.isFunction(command)) {
//                Log.d(TAG, "addMessageListener() - function");
                functionListeners.put(arguments, l);
            } else {
//                Log.d(TAG, "addMessageListener() - command");
                listeners.put(command, l);
            }
        }
    }

    private String joinString(String ... strs) {
        String rs = "";
        for (String s: strs) {
            rs += " " + s;
        }
        return rs;
    }
}
