package com.example.art.art;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class Repair extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
    }

    public void load_done(View view) {
        Spinner spinner = (Spinner)findViewById(R.id.repair_spinner);
        String repair = spinner.getSelectedItem().toString();

        Intent result = new Intent();
        result.putExtra("log_data", "Requested repair for: " + repair + ".");
        setResult(RESULT_OK, result);
        finish();
    }
}
