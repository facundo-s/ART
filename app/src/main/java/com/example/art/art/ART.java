package com.example.art.art;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class ART extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art);
    }

    public void load_assist_activity(View view) {
        Intent intent = new Intent(this, Assistance.class);
        startActivity(intent);
    }

    public void load_repair_activity(View view) {
        Intent intent = new Intent(this, Repair.class);
        startActivity(intent);
    }

    public void load_transportation_activity(View view) {
        Intent intent = new Intent(this, Transportation.class);
        startActivity(intent);
    }
}
