package com.madfist.zpremote.controller;

import android.util.Log;

/**
 * Created by akoleszar on 2017.10.02..
 */

public class ZoomPlayer {
    private Connector connector;
    private String host = null;
    private int port = -1;
    private final static String TAG = "ZoomPlayer";

    public ZoomPlayer() {
        connector = new Connector();
    }

    public void start(String host, int port) {
        this.host = host;
        this.port = port;
        connector.connect(host, port);
    }

    public void pause() {
        connector.disconnect();
    }

    public void resume() {
        if (host != null && port != -1) {
            Log.d(TAG, "resume() - " + host + ":" + port);
            connector.connect(host, port);
        }
    }

    public void destroy() {
        host = null;
        port = -1;
    }

    public String getApplicationName() {
        return connector.executeStringCommand(Connector.MessageCode.GET_APPLICATION_NAME);
    }

    public String getVersion() {
        return connector.executeStringCommand(Connector.MessageCode.GET_VERSION);
    }
}
