package com.madfist.zpremote.controller;

import java.util.Locale;

/**
 * Created by akoleszar on 2017.10.04..
 */
public abstract class MessageListener {
    public interface Finisher {
        void finish();
    }
    public static final boolean KEEP = true;
    public static final boolean DO_NOT_KEEP = false;
    boolean keep = false;

    public MessageListener(boolean k) {
        keep = k;
    }

    abstract public void onMessageReceived(String msg);
}
