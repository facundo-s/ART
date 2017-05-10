package com.example.art.art;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Date;

import static android.view.View.GONE;
import static com.example.art.art.Utils.setButtonState;

public class Transportation extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap map;
    private MarkerOptions fromMarker, toMarker;
    private String fromStr, toStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        time_now_clicked(null);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        PlaceAutocompleteFragment fromAutocomplete = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_from_input);
        fromAutocomplete.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                if (fromMarker == null)
                    fromMarker = new MarkerOptions();
                fromMarker.position(place.getLatLng());
                fromStr = place.toString();
                updateMap();
            }
            @Override
            public void onError(Status status) {
            }
        });
        PlaceAutocompleteFragment toAutocomplete = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_to_input);
        toAutocomplete.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                if (toMarker == null)
                    toMarker = new MarkerOptions();
                toMarker.position(place.getLatLng());
                toStr = place.toString();
                updateMap();
            }
            @Override
            public void onError(Status status) {
            }
        });
        //ActionBar ab = getSupportActionBar();

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
        //ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        // Finally, set the newly created TextView as ActionBar custom view
        //ab.setCustomView(tv);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.back_button);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.back_button);
    }

    private void updateMap() {
        if (map != null) {
            map.clear();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            if (fromMarker != null) {
                builder.include(fromMarker.getPosition());
                map.addMarker(new MarkerOptions().position(fromMarker.getPosition()));
            }
            if (toMarker != null) {
                builder.include(toMarker.getPosition());
                map.addMarker(new MarkerOptions().position(toMarker.getPosition()));
            }
            if (fromMarker != null || toMarker != null) {
                LatLngBounds bounds = builder.build();
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 30);
                map.animateCamera(cu);
                //map.setLatLngBoundsForCameraTarget(bounds);
            }
        }
    }

    public void from_home_clicked(View view) {
//        EditText from_input = (EditText)findViewById(R.id.from_location_input);
//        from_input.setText("Southside");
    }
    public void from_work_clicked(View view) {
//        EditText from_input = (EditText)findViewById(R.id.from_location_input);
//        from_input.setText("Jacobs Hall");
    }
    public void to_home_clicked(View view) {
//        EditText to_input = (EditText)findViewById(R.id.to_location_input);
//        to_input.setText("Southside");
    }
    public void to_work_clicked(View view) {
//        EditText to_input = (EditText)findViewById(R.id.to_location_input);
//        to_input.setText("Jacobs Hall");
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

//        EditText fromInput = (EditText)findViewById(R.id.from_location_input);
//        EditText toInput = (EditText)findViewById(R.id.to_location_input);

        Intent result = new Intent();
        result.putExtra("log_data", "Requested transportation from "
                + fromStr + " to "
                + toStr
                + " on " + Utils.formatDate(requestDate) + ".");
        setResult(RESULT_OK, result);
        finish();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
    }
}
