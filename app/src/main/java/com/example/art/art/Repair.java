package com.example.art.art;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import static android.view.View.GONE;

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
    }

    final int COLOR_BLUE = 0xff33b5e5,
            COLOR_GREY = 0xFFD6D7D7;
    private void setButtonState(Button btn, boolean highlight) {
        btn.getBackground().setColorFilter(highlight ? COLOR_BLUE : COLOR_GREY, PorterDuff.Mode.MULTIPLY);
    }
    public void time_now_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.repair_time_selection);
        Button nowBtn = (Button)findViewById(R.id.repair_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.repair_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.repair_time_other_btn);

        setButtonState(nowBtn, true);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);
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
    }

    // TODO: add time to log
    public void load_done(View view) {
        //Spinner spinner = (Spinner)findViewById(R.id.repair_spinner);
        //String repair = spinner.getSelectedItem().toString();

        Intent result = new Intent();
        result.putExtra("log_data", "Requested repair for: " + "TODO" + ".");//repair + ".");
        setResult(RESULT_OK, result);
        finish();
    }
}
