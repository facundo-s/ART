package com.example.art.art;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Transportation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
    }

    public void from_home_clicked(View view) {
        EditText from_input = (EditText)findViewById(R.id.from_location_input);
        from_input.setText("Southside");
    }
    public void from_work_clicked(View view) {
        EditText from_input = (EditText)findViewById(R.id.from_location_input);
        from_input.setText("Jacobs Hall");
    }
    public void to_home_clicked(View view) {
        EditText to_input = (EditText)findViewById(R.id.to_location_input);
        to_input.setText("Southside");
    }
    public void to_work_clicked(View view) {
        EditText to_input = (EditText)findViewById(R.id.to_location_input);
        to_input.setText("Jacobs Hall");
    }
    public void load_done(View view) {
        Intent result = new Intent();
        result.putExtra("log_data", "Requested transportation.");
        setResult(RESULT_OK, result);
        finish();
    }
}
