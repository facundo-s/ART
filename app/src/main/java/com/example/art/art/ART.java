package com.example.art.art;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;

public class ART extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);
    }

    public void addToLog(String text) {
        TextView t = (TextView)findViewById(R.id.log);
        t.append(text + "\n");
    }

    public void load_assist_activity(View view) {
        Intent intent = new Intent(this, Assistance.class);
        startActivityForResult(intent, 0);
    }

    public void load_repair_activity(View view) {
        Intent intent = new Intent(this, Repair.class);
        startActivityForResult(intent, 1);
    }

    public void load_transportation_activity(View view) {
        Intent intent = new Intent(this, Transportation.class);
        startActivityForResult(intent, 2);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        addToLog(data.getCharSequenceExtra("log_data").toString());
    }

    private void loadDatabase() {
        try {
            URL url = new URL("http://www.android.com/");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());
            } catch (Exception e) {

            } finally {
                connection.disconnect();
            }
        } catch (IOException e) {

        }
    }
}
