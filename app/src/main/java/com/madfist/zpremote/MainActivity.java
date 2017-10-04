package com.madfist.zpremote;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.madfist.zpremote.controller.Connector;
import com.madfist.zpremote.controller.MessageCode;
import com.madfist.zpremote.controller.MessageListener;
import com.madfist.zpremote.controller.ZoomPlayer;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private ZoomPlayer zoomPlayer;
    private boolean userSeeking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoomPlayer = new ZoomPlayer(zoomPlayerConnectorCallback);
        zoomPlayer.setFilenameListener(filenameListener);
        zoomPlayer.setPositionListener(positionListener);
        zoomPlayer.setPlayStateListener(playStateListener);
        zoomPlayer.setFullscreenStateListener(fullscreenStateListener);

        Button connectButton = findViewById(R.id.button_connect);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText hostEditText = findViewById(R.id.text_host);
                String host = hostEditText.getText().toString();
                EditText portEditText = findViewById(R.id.text_port);
                int port = Integer.parseInt(portEditText.getText().toString());
                zoomPlayer.start(host, port);
            }
        });

        SeekBar seekBar = findViewById(R.id.bar_position);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int position = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                if (fromUser) {
                    TextView positionText = findViewById(R.id.text_position);
                    positionText.setText(MessageCode.secondsToTime(i));
                    position = i;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                userSeeking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                userSeeking = false;
                zoomPlayer.seek(position);
            }
        });

        bindImageButton(R.id.button_play_pause, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.playPause();
            }
        });

        bindImageButton(R.id.button_stop, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.stop();
            }
        });

        bindImageButton(R.id.button_prev, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.prev();
            }
        });

        bindImageButton(R.id.button_next, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.next();
            }
        });

        bindImageButton(R.id.button_fullscreen, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.fullscreen();
            }
        });

        bindImageButton(R.id.button_control_bar, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.showHideControlBar();
            }
        });

        bindImageButton(R.id.button_navigator, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.showHideFileNavigator();
            }
        });

        bindImageButton(R.id.button_up, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.navigatorUp();
            }
        });

        bindImageButton(R.id.button_down, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.navigatorDown();
            }
        });

        bindImageButton(R.id.button_enter, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zoomPlayer.navigatorSelect();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        zoomPlayer.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zoomPlayer.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        zoomPlayer.onDestroy();
    }

    private void bindImageButton(int id, View.OnClickListener cl) {
        ImageButton button = findViewById(id);
        button.setOnClickListener(cl);
    }

    private Connector.Callback zoomPlayerConnectorCallback = new Connector.Callback() {
        @Override
        public void onConnected(final boolean state) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (state) {
                        TextView connectionText = findViewById(R.id.text_connection);
                        connectionText.setText(R.string.text_connected);
                        connectionText.setTextColor(getColor(android.R.color.holo_green_dark));
                    } else {
                        TextView connectionText = findViewById(R.id.text_connection);
                        connectionText.setText(R.string.text_not_connected);
                        connectionText.setTextColor(getColor(android.R.color.holo_red_dark));
                    }
                }
            });
        }

        @Override
        public void onError(final int errorCode) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String msg = "";
                    switch (errorCode) {
                        case Connector.CANNOT_CONNECT:
                            msg = getString(R.string.text_cannot_connect);
                    }
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onMessageReceived(String msg) {
            Log.d(TAG, "onMessageReceived(" + msg + ")");
        }
    };

    private MessageListener filenameListener = new MessageListener(MessageListener.KEEP) {
        @Override
        public void onMessageReceived(String msg) {
            final String filename = msg.substring(msg.lastIndexOf('\\') + 1);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView filenameText = findViewById(R.id.text_filename);
                    filenameText.setText(filename);
                }
            });
        }
    };

    private MessageListener positionListener = new MessageListener(MessageListener.KEEP) {
        @Override
        public void onMessageReceived(final String msg) {
            if (userSeeking) {
                return;
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String[] times = msg.split(" / ");
                    SeekBar seekBar = findViewById(R.id.bar_position);
                    int max = MessageCode.timeInSeconds(times[1]);
                    if (seekBar.getMax() != max) {
                        seekBar.setMax(max);
                        TextView durationText = findViewById(R.id.text_duration);
                        durationText.setText(times[1]);
                    }
                    seekBar.setProgress(MessageCode.timeInSeconds(times[0]));
                    TextView positionText = findViewById(R.id.text_position);
                    positionText.setText(times[0]);
                }
            });
        }
    };

    private MessageListener playStateListener = new MessageListener(MessageListener.KEEP) {
        @Override
        public void onMessageReceived(String msg) {
            final int state = Integer.parseInt(msg);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ImageButton playPauseButton = findViewById(R.id.button_play_pause);
                    switch (state) {
                        case 0: //CLOSED
                        case 1: //STOPPED
                        case 2: //PAUSED
                            playPauseButton.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                            break;
                        case 3: //PLAYING
                            playPauseButton.setImageResource(R.drawable.ic_pause_black_24dp);
                            break;
                    }
                }
            });
        }
    };

    private MessageListener fullscreenStateListener = new MessageListener(MessageListener.KEEP) {
        @Override
        public void onMessageReceived(String msg) {
            final boolean fullscreen = msg.equals("1");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ImageButton fullscreenButton = findViewById(R.id.button_fullscreen);
                    if (fullscreen) {
                        fullscreenButton.setImageResource(R.drawable.ic_fullscreen_exit_black_24dp);
                    } else {
                        fullscreenButton.setImageResource(R.drawable.ic_fullscreen_black_24dp);
                    }
                }
            });
        }
    };
}
