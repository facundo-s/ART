package com.example.art.art;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;
import android.graphics.Color;
import android.graphics.Typeface;

public class ART extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);
        ActionBar ab = getSupportActionBar();

        // Create a TextView programmatically.
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        LayoutParams lp = new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, // Width of TextView
                LayoutParams.WRAP_CONTENT); // Height of TextView


        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);

        // Set text to display in TextView
        tv.setText("A R T"); // ActionBar title text

        // Set the text color of TextView to black
        tv.setTextColor(Color.WHITE);
        tv.setTextSize((float) 30);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setGravity(1);
        tv.setPadding(0,0,45,0);

        // Set the monospace font for TextView text
        // This will change ActionBar title text font
        //tv.setTypeface(Typeface.MONOSPACE);

        // Set the ActionBar display option
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        // Finally, set the newly created TextView as ActionBar custom view
        ab.setCustomView(tv);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.button_menu);

    }

//    public void addToLog(String text) {
//        TextView t = (TextView)findViewById(R.id.log);
//        t.append(text + "\n");
//    }

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
        if (data != null && data.getCharSequenceExtra("log_data") != null) {
//            addToLog(data.getCharSequenceExtra("log_data").toString());
            View mainView = findViewById(R.id.activity_art);
            Snackbar snackbar = Snackbar.make(mainView, "Request processed!", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    private void loadDatabase() {
        try {
            URL url = new URL("http://www.android.com/");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String result = "";
                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    result += line + "\n";
                }
                JSONObject json = new JSONObject(result);
            } catch (Exception e) {

            } finally {
                connection.disconnect();
            }
        } catch (IOException e) {

        }
    }
}
