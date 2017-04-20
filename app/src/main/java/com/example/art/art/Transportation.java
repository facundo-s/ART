package com.example.art.art;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Transportation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
    }

    public void load_done(View view) {
        Intent result = new Intent();
        result.putExtra("log_data", "Requested transportation.");
        setResult(RESULT_OK, result);
        finish();
    }
}
