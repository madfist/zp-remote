package com.madfist.zpremote.controller;

import android.util.Log;
import android.util.SparseArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by akoleszar on 2017.10.02..
 */

public class Connector {
    public interface Callback {
        void onConnected(boolean state);
        void onError(int errorCode);
        void onMessageReceived(String msg);
    }

    private Socket socket;
    private Scanner reader;
    private PrintWriter writer;
    private ExecutorService pool = Executors.newCachedThreadPool();
    private static final String TAG = "Connector";
    private volatile boolean listening = false;
    private boolean connected = false;
    private SparseArray<MessageListener> listeners;
    private Callback callback;

    public static final int CANNOT_CONNECT = 1;

    public Connector(Callback cb) {
        callback = cb;
        socket = new Socket();
        listeners = new SparseArray<>();
    }

    public void connect(final String address, final int port) {
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    socket.connect(new InetSocketAddress(address, port));
                    listening = true;
                    reader = new Scanner(socket.getInputStream());
                    writer = new PrintWriter(socket.getOutputStream());
                    listen();
                    callback.onConnected(true);
                    connected = true;
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
                    listening = false;
                    reader.close();
                    writer.close();
                    socket.close();
                    callback.onConnected(false);
                    connected = false;
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
                        int messageCode = MessageCode.parse(message.substring(0,4));
                        MessageListener ml = listeners.get(messageCode);
                        if (ml != null) {
                            ml.onMessageReceived(message.substring(5));
                            if (!ml.keep) {
                                listeners.remove(messageCode);
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
        addMessageListener(command, l);
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

    public void addMessageListener(int command, MessageListener l) {
        if (l != null && listeners.get(command) == null) {
            listeners.put(command, l);
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
