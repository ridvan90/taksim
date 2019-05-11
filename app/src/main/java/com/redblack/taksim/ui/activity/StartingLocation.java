package com.redblack.taksim.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.redblack.taksim.Main;
import com.redblack.taksim.R;

import java.util.Arrays;

public class StartingLocation extends AppCompatActivity {

    private ImageButton back;
    private double get_latitude = 0.0, get_longitude = 0.0;
    private String get_name = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_location);

        back = findViewById(R.id.back_starting_place_map);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Initialize Places.
        Places.initialize(StartingLocation.this, getString(R.string.google_maps_key));
        // Create a new Places client instance.
        PlacesClient placesClient = Places.createClient(this);

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment_starting_place);

        //Disable Search icon of autocomplete fragment and change text of it
        autocompleteFragment.setHint(getString(R.string.starting_place));
        ImageView searchIcon = (ImageView)((LinearLayout)autocompleteFragment.getView()).getChildAt(0);
        searchIcon.setVisibility(View.GONE);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.

                final LatLng location = place.getLatLng();
                get_latitude = location.latitude;
                get_longitude = location.longitude;
                get_name = place.getName();

                //Send Value of selected Place
                Intent intent = new Intent(StartingLocation.this,Main.class);
                if(!get_name.equals("")) {
                    intent.putExtra("origin_place_adres", get_name);//Address name
                    intent.putExtra("origin_latitude",String.valueOf(get_latitude));//Latitude
                    intent.putExtra("origin_longitude",String.valueOf(get_longitude));//Longitude
                    setResult(RESULT_OK, intent);
                    finish();
                }


            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("TAG", "An error occurred: " + status);
            }
        });
    }
}
