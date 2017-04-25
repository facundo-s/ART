package com.example.art.art;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Date;

import static android.view.View.GONE;
import static com.example.art.art.Utils.setButtonState;

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

    String timeOption;
    public void time_now_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.transportation_time_selection);
        Button nowBtn = (Button)findViewById(R.id.transportation_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.transportation_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.transportation_time_other_btn);

        setButtonState(nowBtn, true);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);

        timeOption = "now";
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

        timeOption = "tomorrow";
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

        timeOption = "other";
    }

    // TODO: add time and locations to log
    public void load_done(View view) {
        Date requestDate;
        if (timeOption.equals("now")) {
            requestDate = new Date();
        } else if (timeOption.equals("tomorrow")) {
            requestDate = Utils.getTomorrow();
        } else {
            DatePicker datePicker = (DatePicker)findViewById(R.id.transportation_date_picker);
            TimePicker timePicker = (TimePicker)findViewById(R.id.transportation_time_picker);
            requestDate = Utils.getDate(datePicker, timePicker);
        }

        Intent result = new Intent();
        result.putExtra("log_data", "Requested transportation from "
                + "TODO" + " to "
                + "TODO" + " on "
                + Utils.formatDate(requestDate) + ".");
        setResult(RESULT_OK, result);
        finish();
    }
}
