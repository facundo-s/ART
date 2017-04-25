package com.example.art.art;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static android.view.View.GONE;

public class Transportation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        time_now_clicked(null);
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

    final int COLOR_BLUE = 0xff33b5e5,
            COLOR_GREY = 0xFFD6D7D7;
    private void setButtonState(Button btn, boolean highlight) {
        btn.getBackground().setColorFilter(highlight ? COLOR_BLUE : COLOR_GREY, PorterDuff.Mode.MULTIPLY);
    }
    public void time_now_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.transportation_time_selection);
        Button nowBtn = (Button)findViewById(R.id.transportation_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.transportation_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.transportation_time_other_btn);

        setButtonState(nowBtn, true);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);
    }
    public void time_tomorrow_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.transportation_time_selection);
        Button nowBtn = (Button)findViewById(R.id.transportation_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.transportation_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.transportation_time_other_btn);

        setButtonState(nowBtn, false);
        setButtonState(tomorrowBtn, true);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);
    }
    public void time_other_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.transportation_time_selection);
        Button nowBtn = (Button)findViewById(R.id.transportation_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.transportation_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.transportation_time_other_btn);

        setButtonState(nowBtn, false);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, true);
        timeSelector.setVisibility(View.VISIBLE);
    }

    // TODO: add time and locations to log
    public void load_done(View view) {
        Intent result = new Intent();
        result.putExtra("log_data", "Requested transportation.");
        setResult(RESULT_OK, result);
        finish();
    }
}
