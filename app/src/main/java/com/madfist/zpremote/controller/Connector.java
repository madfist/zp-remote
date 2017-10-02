package com.madfist.zpremote.controller;

import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akoleszar on 2017.10.02..
 */

public class Connector {
    private Socket socket;
    private Scanner reader;
    private PrintWriter writer;
    private ExecutorService pool = Executors.newFixedThreadPool(1);
    private static final String TAG = "Connector";

    public Connector() {
        socket = new Socket();
    }

    public class MessageCode {
        public static final String GET_APPLICATION_NAME = "0000";
        public static final String GET_VERSION = "0001";
    }

    public void connect(final String address, final int port) {
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    socket.connect(new InetSocketAddress(address, port));
                    reader = new Scanner(socket.getInputStream());
                    writer = new PrintWriter(socket.getOutputStream());
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
                    socket.close();
                } catch (IOException e) {
                    Log.e(TAG, "disconnect() failed - " + e.getMessage());
                }
            }
        });
    }

    public String executeStringCommand(final String command) {
        RunnableFuture<String> cmd = (new RunnableFuture<String>() {
            private String result = "";
            private boolean done = false;
            @Override
            public boolean cancel(boolean b) {
                done = false;
                return true;
            }

            @Override
            public boolean isCancelled() {
                return !done;
            }

            @Override
            public boolean isDone() {
                return done;
            }

            @Override
            public String get() throws InterruptedException, ExecutionException {
                while (!done) {
                    Thread.sleep(300);
                }
                Log.d(TAG, "executeStringCommand(" + command + ") - result:" + result);
                return result;
            }

            @Override
            public String get(long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return result;
            }

            @Override
            public void run() {
                Log.d(TAG, "executeStringCommand(" + command + ")");
                writer.println(command);
                writer.flush();
                if (reader.hasNextLine()) {
                    String response = reader.nextLine();
                    Log.d(TAG, "executeStringCommand(" + command + ") - got response : " + response);
                    result = response.substring(5);
                }
                done = true;
            }
        });
        String result = "";
        pool.execute(cmd);
        try {
            result = cmd.get();
        } catch (Exception e) {
            Log.e(TAG, "executeStringCommand(" + command + ") - failed : " + e.getMessage());
        }
        return result;
    }
}
