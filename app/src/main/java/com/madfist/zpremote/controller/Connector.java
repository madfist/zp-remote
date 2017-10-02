package com.madfist.zpremote.controller;

import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by akoleszar on 2017.10.02..
 */

public class Connector {
    private Socket socket;
    private Scanner reader;
    private PrintWriter writer;
    private static final String TAG = "Connector";

    public Connector() {
        socket = new Socket();
        try {
            reader = new Scanner(socket.getInputStream());
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            Log.e(TAG, "<init> failed - " + e.getMessage());
        }
    }

    public class MessageCode {
        public static final String GET_APPLICATION_NAME = "0000";
        public static final String GET_VERSION = "0001";
    }

    public void connect(String address, int port) {
        try {
            socket.connect(new InetSocketAddress(address, port));
        } catch (IOException e) {
            Log.e(TAG, "connect() failed - " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            Log.e(TAG, "disconnect() failed - " + e.getMessage());
        }
    }

    public String executeStringCommand(String command) {
        writer.println(command);
        writer.flush();
        if (reader.hasNextLine()) {
            String response = reader.nextLine();
            Pattern p = Pattern.compile(command + "\\ (.*)");
            Matcher m = p.matcher(response);
            if (m.matches()) {
                return m.group(1);
            }
        }
        return "";
    }
}
