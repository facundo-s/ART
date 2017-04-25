package com.example.art.art;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.view.View.GONE;

public class Assistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);

        final CheckBox otherCheckBox = (CheckBox)findViewById(R.id.assistance_other);
        final EditText otherTextInput = (EditText)findViewById(R.id.assistance_other_input);
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
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.assistance_time_selection);
        Button nowBtn = (Button)findViewById(R.id.assistance_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.assistance_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.assistance_time_other_btn);

        setButtonState(nowBtn, true);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);
    }
    public void time_tomorrow_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.assistance_time_selection);
        Button nowBtn = (Button)findViewById(R.id.assistance_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.assistance_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.assistance_time_other_btn);

        setButtonState(nowBtn, false);
        setButtonState(tomorrowBtn, true);
        setButtonState(otherTimeBtn, false);
        timeSelector.setVisibility(GONE);
    }
    public void time_other_clicked(View view) {
        LinearLayout timeSelector = (LinearLayout)findViewById(R.id.assistance_time_selection);
        Button nowBtn = (Button)findViewById(R.id.assistance_time_now_btn);
        Button tomorrowBtn = (Button)findViewById(R.id.assistance_time_tomorrow_btn);
        Button otherTimeBtn = (Button)findViewById(R.id.assistance_time_other_btn);

        setButtonState(nowBtn, false);
        setButtonState(tomorrowBtn, false);
        setButtonState(otherTimeBtn, true);
        timeSelector.setVisibility(View.VISIBLE);
    }

    // TODO: add time and what they need help with to log
    public void load_done(View view) {
        //ART parent = (ART)getParent();
        //parent.addToLog("Requested assistance.");
//        TextView log = (TextView) findViewById(R.id.log);
//        log.setText("sladffajsldh");
        //log.append("\n Assistance requested");
        Intent result = new Intent();
        RadioGroup rg = (RadioGroup)findViewById(R.id.gender_selection_group);
        int genderSelectionId = rg.getCheckedRadioButtonId();
        RadioButton genderSelectionButton = (RadioButton)findViewById(genderSelectionId);
        CharSequence value = genderSelectionButton.getText();
        String gender = "unspecified";
        if (value.equals("Male")) {
            gender = "male";
        } else if (value.equals("Female")) {
            gender = "female";
        }
        result.putExtra("gender", gender);
        result.putExtra("log_data", "Requested assistance by gender: " + gender + ".");
        setResult(RESULT_OK, result);
        finish();
    }
}
