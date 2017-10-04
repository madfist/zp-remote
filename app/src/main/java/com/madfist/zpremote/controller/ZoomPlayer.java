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

    public ZoomPlayer(Connector.Callback callback) {
        connector = new Connector(callback);
    }

    public void setPlayStateListener(MessageListener playStateListener) {
        connector.addMessageListener(MessageCode.STATE_CHANGE, playStateListener);
    }

    public void setFullscreenStateListener(MessageListener fullscreenStateListener) {
        connector.addMessageListener(MessageCode.CURRENT_FULLSCREEN_STATE, fullscreenStateListener);
    }

    public void setFilenameListener(MessageListener filenameListener) {
        connector.addMessageListener(MessageCode.CURRENTLY_LOADED_FILE, filenameListener);
    }

    public void setPositionListener(MessageListener positionListener) {
        connector.addMessageListener(MessageCode.POSITION_UPDATE, positionListener);
    }

    public void start(String host, int port) {
        this.host = host;
        this.port = port;
        connector.connect(host, port);
    }

    public void onPause() {
        connector.disconnect();
    }

    public void onResume() {
        if (host != null && port != -1) {
            Log.d(TAG, "onResume() - " + host + ":" + port);
            connector.connect(host, port);
        }
    }

    public void onDestroy() {
        host = null;
        port = -1;
    }

    public void playPause() {
        executeZpFunction("fnPlay");
    }

    public void stop() {
        executeZpFunction("fnStop");
    }

    public void prev() {
        executeZpFunction("fnPrevTrack");
    }

    public void next() {
        executeZpFunction("fnNextTrack");
    }

    public void fullscreen() {
        executeZpFunction("fnFullScreen");
    }

    public void seek(int seconds) {
        executeZpExFunction("exSeekTo", Integer.toString(seconds));
    }

    public void showHideControlBar() {
        executeZpFunction("fnBar");
    }

    public void showHideFileNavigator() {
        executeZpFunction("fnFileNav");
    }

    public void navigatorUp() {
        executeZpNavFunction("nvUp");
    }

    public void navigatorDown() {
        executeZpNavFunction("nvDown");
    }

    public void navigatorSelect() {
        executeZpNavFunction("nvSelect");
    }

    private void executeZpFunction(String function) {
        connector.executeCommand(MessageCode.CALL_ZP_FUNCTION, getFunctionCalledChecker(function), function);
    }

    private void executeZpExFunction(String ... functionAndParams) {
        connector.executeCommand(MessageCode.CALL_ZP_EXFUNCTION, getFunctionCalledChecker(functionAndParams[0]), functionAndParams);
    }

    private void executeZpNavFunction(String function) {
        connector.executeCommand(MessageCode.CALL_ZP_NVFUNCTION, getFunctionCalledChecker(function), function);
    }

    private MessageListener getFunctionCalledChecker(final String function) {
        return new MessageListener(MessageListener.DO_NOT_KEEP) {
            @Override
            public void onMessageReceived(String msg) {
                if (!msg.equals(function)) {
                    Log.w(TAG, "getFunctionCalledChecker(" + function + ") - got: " + msg);
                }
            }
        };
    }
}
