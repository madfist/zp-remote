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
        void onConnected();
        void onDisconnected();
        void onMessageReceived(String msg);
    }
    public interface StringCallback {
        void onStringReceived(String msg);
    }
    public interface NumberCallback {
        void onNumberReceived(int num);
    }
    private Socket socket;
    private Scanner reader;
    private PrintWriter writer;
    private ExecutorService pool = Executors.newCachedThreadPool();
    private static final String TAG = "Connector";
    private boolean listening = false;
    private SparseArray<StringCallback> stringCallbacks;
    private SparseArray<NumberCallback> numberCallbacks;
    private Callback callback;

    public Connector(Callback cb) {
        callback = cb;
        socket = new Socket();
        stringCallbacks = new SparseArray<>();
        numberCallbacks = new SparseArray<>();
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
                    callback.onConnected();
                } catch (IOException e) {
                    Log.e(TAG, "connect() failed - " + e.getMessage());
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
                    callback.onDisconnected();
                } catch (IOException e) {
                    Log.e(TAG, "disconnect() failed - " + e.getMessage());
                }
            }
        });
    }

    public void listen() {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                while(listening) {
                    if (reader.hasNextLine()) {
                        String message = reader.nextLine();
                        int messageCode = MessageCode.parse(message.substring(0,4));
                        StringCallback cb = stringCallbacks.get(messageCode);
                        NumberCallback ncb = numberCallbacks.get(messageCode);
                        if (cb != null) {
                            cb.onStringReceived(message.substring(5));
                            stringCallbacks.remove(messageCode);
                        } else if (ncb != null) {
                            ncb.onNumberReceived(Integer.parseInt(message.substring(5)));
                            numberCallbacks.remove(messageCode);
                        } else {
                            callback.onMessageReceived(message);
                        }
                    }
                }
            }
        });
    }

    public void executeStringCommand(int command, StringCallback cb) {
        stringCallbacks.put(command, cb);
        executeCommand(command);
    }

    public void executeNumberCommand(int command, NumberCallback cb) {
        numberCallbacks.put(command, cb);
        executeCommand(command);
    }

    /**
     * Call a standard, extended or navigation ZoomPlayer function
     * @param command function type
     * @param function function name
     * @see <a href=https://inmatrix.com/zplayer/highlights/zpfunctions.shtml>ZoomPlayer Functions</a>
     */
    public void executeFunctionCommand(int command, final String function) {
        stringCallbacks.put(command, new StringCallback() {
            @Override
            public void onStringReceived(String msg) {
                if (function.equals(msg)) {
                    Log.d(TAG, "executeFunctionCommand(" + function + ") - done");
                } else {
                    Log.w(TAG, "executeFunctionCommand(" + function + ") - received message for different function: " + msg);
                }
            }
        });
        executeCommand(command, function);
    }

    private String joinString(String ... strs) {
        String rs = "";
        for (String s: strs) {
            rs += " " + s;
        }
        return rs;
    }

    private void executeCommand(final int command, String ... args) {
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
}
