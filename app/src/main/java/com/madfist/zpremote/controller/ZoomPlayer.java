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

    public ZoomPlayer(Connector.Callback cb) {
        connector = new Connector(cb);
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

    public void playPause() {
        connector.executeFunctionCommand(MessageCode.CALL_ZP_FUNCTION, "fnPlay");
    }

    public void showHideControlBar() {
        connector.executeFunctionCommand(MessageCode.CALL_ZP_FUNCTION, "fnBar");
    }

    public void showHideFileNavigator() {
        connector.executeFunctionCommand(MessageCode.CALL_ZP_FUNCTION, "fnFileNav");
    }

    public void navigatorUp() {
        connector.executeFunctionCommand(MessageCode.CALL_ZP_NVFUCNTION, "nvUp");
    }

    public void navigatorDown() {
        connector.executeFunctionCommand(MessageCode.CALL_ZP_NVFUCNTION, "nvDown");
    }

    public void navigatorSelect() {
        connector.executeFunctionCommand(MessageCode.CALL_ZP_NVFUCNTION, "nvSelect");
    }
}
