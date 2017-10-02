package com.madfist.zpremote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.madfist.zpremote.controller.ZoomPlayer;

public class MainActivity extends Activity {
    private ZoomPlayer zoomPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zoomPlayer = new ZoomPlayer();

        Button connectButton = (Button) findViewById(R.id.button_connect);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText hostEditText = (EditText) findViewById(R.id.text_host);
                String host = hostEditText.getText().toString();
                EditText portEditText = (EditText) findViewById(R.id.text_port);
                int port = Integer.parseInt(portEditText.getText().toString());
                zoomPlayer.start(host, port);
            }
        });
        final TextView responseText = findViewById(R.id.text_response);
        Button appNameButton = findViewById(R.id.button_app_name);
        appNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                responseText.setText(zoomPlayer.getApplicationName());
            }
        });
        Button versionButton = findViewById(R.id.button_version);
        versionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                responseText.setText(zoomPlayer.getVersion());
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
}
