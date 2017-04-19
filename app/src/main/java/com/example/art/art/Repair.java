package com.example.art.art;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Repair extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
    }

    public void load_done(View view) {
        finish();
    }
}
