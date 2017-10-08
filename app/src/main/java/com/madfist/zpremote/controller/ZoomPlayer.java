package com.madfist.zpremote.controller;

import com.madfist.zpremote.Log;

/**
 * Created by akoleszar on 2017.10.02..
 */

public class ZoomPlayer {
    private Connector connector;
    private String host = null;
    private int port = -1;
    private final static String TAG = "ZoomPlayer";
    private int selectedAudioTrack = -1;
    private int selectedSubtitle = -1;
    private int audioTrackCount = 0;
    private int subtitleTrackCount = 0;

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
        connector.addMessageListener(MessageCode.CURRENT_POSITION, positionListener);
    }

    public void setVolumeListener(MessageListener volumeListener) {
        connector.addMessageListener(MessageCode.AUDIO_VOLUME, volumeListener);
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

    public void getDuration(MessageListener durationListener) {
        connector.executeCommand(MessageCode.SET_TIMELINE_UPDATES, null, "0");
        connector.executeCommand(MessageCode.GET_CURRENT_DURATION, durationListener);
    }

    public void getPosition() {
        connector.executeCommand(MessageCode.GET_CURRENT_POSITION, null);
    }

    public void initAudioAndSubtitles() {
        getAudioTrackCount();
        getCurrentAudioTrack();
        getSubtitleCount();
        getCurrentSubtitle();
    }

    public void playPause() {
        executeZpFunction("fnPlay");
    }

    public void stop() {
        executeZpFunction("fnStop", new MessageListener.Finisher() {
            @Override
            public void finish(String msg) {
                getPosition();
            }
        });
    }

    public void prev() {
        executeZpFunction("fnPrevTrack");
    }

    public void next() {
        executeZpFunction("fnNextTrack");
    }

    public void fullscreen() {
        executeZpFunction("fnFullScreen", new MessageListener.Finisher() {
            @Override
            public void finish(String msg) {
                connector.executeCommand(MessageCode.GET_FULLSCREEN_STATE, null);
            }
        });
    }

    public void mute() {
        executeZpFunction("fnMute");
    }

    public void volumeDown() {
        executeZpFunction("fnVolDown");
    }

    public void volumeUp() {
        executeZpFunction("fnVolUp");
    }

    public void getVolume() {
        connector.executeCommand(MessageCode.GET_AUDIO_VOLUME, null);
    }

    public void changeAudio() {
        if (audioTrackCount > 1) {
            final String newAudioTrack = Integer.toString((selectedAudioTrack + 1) % audioTrackCount);
            connector.executeCommand(MessageCode.SET_AUDIO_TRACK, new MessageListener(MessageListener.DO_NOT_KEEP) {
                @Override
                public void onMessageReceived(String msg) {
                    if (newAudioTrack.equals(msg)) {
                        selectedAudioTrack = Integer.parseInt(msg);
                    }
                }
            }, newAudioTrack);
        }
    }

    public void changeSubtitle() {
        if (subtitleTrackCount > 1) {
            final String newSubtitle = Integer.toString((selectedSubtitle + 2) % subtitleTrackCount);
            connector.executeCommand(MessageCode.SET_SUBTITLE_TRACK, new MessageListener(MessageListener.DO_NOT_KEEP) {
                @Override
                public void onMessageReceived(String msg) {
                    if (newSubtitle.equals(msg)) {
                        selectedSubtitle = Integer.parseInt(msg);
                    }
                }
            }, newSubtitle);
        }
    }

    public void seek(int seconds) {
        executeZpExFunction("exSeekTo," + Integer.toString(seconds));
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

    private void getCurrentAudioTrack() {
        connector.executeCommand(MessageCode.DVD_MEDIA_ACTIVE_AUDIO_TRACK, new MessageListener(MessageListener.DO_NOT_KEEP) {
            @Override
            public void onMessageReceived(String msg) {
                selectedAudioTrack = Integer.parseInt(msg);
            }
        });
    }

    private void getAudioTrackCount() {
        connector.executeCommand(MessageCode.GET_DVD_MEDIA_AUDIO_TRACK_COUNT, new MessageListener(MessageListener.DO_NOT_KEEP) {
            @Override
            public void onMessageReceived(String msg) {
                audioTrackCount = Integer.parseInt(msg);
            }
        });
    }

    private void getCurrentSubtitle() {
        connector.executeCommand(MessageCode.GET_DVD_MEDIA_ACTIVE_SUB, new MessageListener(MessageListener.DO_NOT_KEEP) {
            @Override
            public void onMessageReceived(String msg) {
                selectedSubtitle = Integer.parseInt(msg);
            }
        });
    }

    private void getSubtitleCount() {
        connector.executeCommand(MessageCode.GET_DVD_MEDIA_SUB_COUNT, new MessageListener(MessageListener.DO_NOT_KEEP) {
            @Override
            public void onMessageReceived(String msg) {
                subtitleTrackCount = Integer.parseInt(msg);
            }
        });
    }

    private void executeZpFunction(String function) {
        connector.executeCommand(MessageCode.CALL_ZP_FUNCTION, getFunctionCalledChecker(function, null), function);
    }

    private void executeZpExFunction(String function) {
        connector.executeCommand(MessageCode.CALL_ZP_EXFUNCTION, getFunctionCalledChecker(function, null), function);
    }

    private void executeZpNavFunction(String function) {
        connector.executeCommand(MessageCode.CALL_ZP_NVFUNCTION, getFunctionCalledChecker(function, null), function);
    }

    private void executeZpFunction(String function, MessageListener.Finisher finisher) {
        connector.executeCommand(MessageCode.CALL_ZP_FUNCTION, getFunctionCalledChecker(function,finisher), function);
    }

    private void executeZpExFunction(String function, MessageListener.Finisher finisher) {
        connector.executeCommand(MessageCode.CALL_ZP_EXFUNCTION, getFunctionCalledChecker(function, finisher), function);
    }

    private void executeZpNavFunction(String function,MessageListener.Finisher finisher) {
        connector.executeCommand(MessageCode.CALL_ZP_NVFUNCTION, getFunctionCalledChecker(function, finisher), function);
    }

    private MessageListener getFunctionCalledChecker(final String function, final MessageListener.Finisher finisher) {
        return new MessageListener(MessageListener.DO_NOT_KEEP) {
            @Override
            public void onMessageReceived(String msg) {
                if (msg.equals(function)) {
                    if (finisher != null) {
                        finisher.finish(msg);
                    }
                } else {
                    Log.w(TAG, "getFunctionCalledChecker(" + function + ") - got: " + msg);
                }
            }
        };
    }
}
