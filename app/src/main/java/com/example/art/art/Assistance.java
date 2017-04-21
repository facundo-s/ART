package com.example.art.art;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Assistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);

        final CheckBox otherCheckBox = (CheckBox)findViewById(R.id.assistance_other);
        final TextView otherTextView = (TextView)findViewById(R.id.other_text_view);
        final EditText otherTextInput = (EditText)findViewById(R.id.assistance_other_input);
        otherCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(otherCheckBox.isChecked()){
                    otherTextView.setVisibility(View.VISIBLE);
                    otherTextInput.setVisibility(View.VISIBLE);
                }else{
                    otherTextView.setVisibility(View.GONE);
                    otherTextInput.setVisibility(View.GONE);
                }
            }
        });
    }

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
