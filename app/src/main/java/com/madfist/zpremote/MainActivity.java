package com.madfist.zpremote;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.madfist.zpremote.controller.Connector;
import com.madfist.zpremote.controller.ZoomPlayer;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private ZoomPlayer zoomPlayer;
    private boolean zoomPlayerConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zoomPlayer = new ZoomPlayer(new Connector.Callback() {
            @Override
            public void onConnected() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView connectionText = findViewById(R.id.text_connection);
                        connectionText.setText(R.string.text_connected);
                    }
                });
                zoomPlayerConnected = true;
            }

            @Override
            public void onDisconnected() {
                zoomPlayerConnected = false;
            }

            @Override
            public void onMessageReceived(String msg) {
                Log.d(TAG, "onMessageReceived(" + msg + ")");
            }
        });

        bindButton(R.id.button_connect, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText hostEditText = findViewById(R.id.text_host);
                String host = hostEditText.getText().toString();
                EditText portEditText = findViewById(R.id.text_port);
                int port = Integer.parseInt(portEditText.getText().toString());
                zoomPlayer.start(host, port);
            }
        });

        bindButton(R.id.button_play_pause, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zoomPlayerConnected) {
                    zoomPlayer.playPause();
                }
            }
        });

        bindButton(R.id.button_control_bar, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zoomPlayerConnected) {
                    zoomPlayer.showHideControlBar();
                }
            }
        });

        bindButton(R.id.button_navigator, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zoomPlayerConnected) {
                    zoomPlayer.showHideFileNavigator();
                }
            }
        });

        bindButton(R.id.button_up, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zoomPlayerConnected) {
                    zoomPlayer.navigatorUp();
                }
            }
        });

        bindButton(R.id.button_down, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zoomPlayerConnected) {
                    zoomPlayer.navigatorDown();
                }
            }
        });

        bindButton(R.id.button_enter, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zoomPlayerConnected) {
                    zoomPlayer.navigatorSelect();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        zoomPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        zoomPlayer.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        zoomPlayer.destroy();
    }

    private void bindButton(int id, View.OnClickListener cl) {
        Button button = findViewById(id);
        button.setOnClickListener(cl);
    }
}
