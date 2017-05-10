package com.example.art.art;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Date;

import static android.view.View.GONE;
import static com.example.art.art.Utils.setButtonState;

public class Repair extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);

        final CheckBox otherCheckBox = (CheckBox)findViewById(R.id.repair_other);
        final EditText otherTextInput = (EditText)findViewById(R.id.repair_other_input);
        otherCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otherCheckBox.isChecked()){
                    otherTextInput.setVisibility(View.VISIBLE);
                    otherTextInput.requestFocus();
                } else {
                    otherTextInput.setVisibility(View.INVISIBLE);
                }
            }
        });
        time_now_clicked(null);
        ActionBar ab = getSupportActionBar();

        // Create a TextView programmatically.
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        ViewGroup.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, // Width of TextView
                ViewGroup.LayoutParams.WRAP_CONTENT); // Height of TextView


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

    String timeOption;
    public void time_now_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.repair_time_selection);
        Button nowBtn = (Button)findViewById(R.id.repair_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.repair_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.repair_time_other_btn);

        setButtonState(nowBtn, true);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);

        timeOption = "now";
    }
    public void time_tomorrow_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.repair_time_selection);
        Button nowBtn = (Button)findViewById(R.id.repair_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.repair_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.repair_time_other_btn);

        setButtonState(nowBtn, false);
        setButtonState(tomorrowBtn, true);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);

        timeOption = "tomorrow";
    }
    public void time_other_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.repair_time_selection);
        Button nowBtn = (Button)findViewById(R.id.repair_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.repair_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.repair_time_other_btn);

        setButtonState(nowBtn, false);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, true);
        timeSelector.setVisibility(View.VISIBLE);

        timeOption = "other";
    }

    // TODO: add time to log
    public void load_done(View view) {
        ArrayList<String> options = new ArrayList<>();
        LinearLayout optionsLayout = (LinearLayout)findViewById(R.id.repair_options_layout);
        for (int i = 0; i < optionsLayout.getChildCount() - 1; i++) {
            CheckBox option = (CheckBox)optionsLayout.getChildAt(i);
            if (option.isChecked()) {
                options.add(option.getText().toString());
            }
        }
        CheckBox otherOptionCheckBox = (CheckBox)findViewById(R.id.repair_other);
        EditText otherOptionInput = (EditText)findViewById(R.id.repair_other_input);
        if (otherOptionCheckBox.isChecked()) {
            options.add("Other(" + otherOptionInput.getText() + ")");
        }

        Date requestDate;
        if (timeOption.equals("now")) {
            requestDate = new Date();
        } else if (timeOption.equals("tomorrow")) {
            requestDate = Utils.getTomorrow();
        } else {
            DatePicker datePicker = (DatePicker)findViewById(R.id.repair_date_picker);
            TimePicker timePicker = (TimePicker)findViewById(R.id.repair_time_picker);
            requestDate = Utils.getDate(datePicker, timePicker);
        }

        Intent result = new Intent();
        result.putExtra("log_data", "Requested repair for "
                + Utils.joinStr(options, ", ")
                + " on "
                + Utils.formatDate(requestDate) + ".");
        setResult(RESULT_OK, result);
        finish();
    }
}
