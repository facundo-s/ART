package com.example.art.art;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class Assistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);
    }

    public void load_done(View view) {
        //ART parent = (ART)getParent();
        //parent.addToLog("Requested assistance.");
//        TextView log = (TextView) findViewById(R.id.log);
//        log.setText("sladffajsldh");
        //log.append("\n Assistance requested");
        Intent result = new Intent();
        result.putExtra("log_data", "Requested assistance.");
        setResult(RESULT_OK, result);
        finish();
    }
}
