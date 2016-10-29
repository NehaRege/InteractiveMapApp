package com.test.interactivemapsjsu;

import android.Manifest;
import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.test.interactivemapsjsu.BuildingActivity.BbcActivity;
import com.test.interactivemapsjsu.BuildingActivity.EnggActivity;
import com.test.interactivemapsjsu.BuildingActivity.GarageActivity;
import com.test.interactivemapsjsu.BuildingActivity.KingActivity;
import com.test.interactivemapsjsu.BuildingActivity.SuActivity;
import com.test.interactivemapsjsu.BuildingActivity.YuhActivity;

public class MainActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    String TAG = "MainActivity";

    public static int ACCESS_LOCATION_REQUEST_CODE = 323;

    private static final String[] Locations = new String[]{
            "King Library", "Engineering Building", "Yoshihiro Uchida Hall", "Student Union", "BBC", "South Parking Garage"
    };

    public Location lastLocation;
    public String latitude, longitude;

    private Button buttonKing;
    private Button buttonEng;
    private Button buttonGarage;
    private Button buttonBBC;
    private Button buttonYUH;
    private Button buttonSU;

    private GoogleApiClient googleApiClient;

    private AutoCompleteTextView textView;
    private String starttext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setViews();

        actionBarSetUp();

        googleApiClientSetUp();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Locations);
        textView = (AutoCompleteTextView) findViewById(R.id.location_list);
        textView.setAdapter(adapter);
        textView.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                check();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                check();
            }

            @Override
            public void afterTextChanged(Editable s) {
                check();
            }
        });


        buttonKing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                buttonKing.setVisibility(View.VISIBLE);
//                buttonKing.setBackgroundColor(Color.TRANSPARENT);

                Intent intent = new Intent(MainActivity.this,KingActivity.class);
                intent.putExtra("king_key","king");

                startActivity(intent);



            }
        });

        buttonEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                buttonEng.setVisibility(View.VISIBLE);
//                buttonEng.setBackgroundColor(Color.TRANSPARENT);

                Intent intent = new Intent(MainActivity.this,EnggActivity.class);
                intent.putExtra("engg_key","engg");

                startActivity(intent);

            }
        });

        buttonGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                buttonGarage.setVisibility(View.VISIBLE);
//                buttonGarage.setBackgroundColor(Color.TRANSPARENT);

                Intent intent = new Intent(MainActivity.this,GarageActivity.class);
                startActivity(intent);
            }
        });

        buttonBBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                buttonBBC.setVisibility(View.VISIBLE);
//                buttonBBC.setBackgroundColor(Color.TRANSPARENT);

                Intent intent = new Intent(MainActivity.this,BbcActivity.class);
                startActivity(intent);
            }
        });

        buttonSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                buttonSU.setVisibility(View.VISIBLE);
//                buttonSU.setBackgroundColor(Color.TRANSPARENT);

                Intent intent = new Intent(MainActivity.this,SuActivity.class);
                startActivity(intent);
            }
        });

        buttonYUH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                buttonYUH.setVisibility(View.VISIBLE);
//                buttonYUH.setBackgroundColor(Color.TRANSPARENT);

                Intent intent = new Intent(MainActivity.this,YuhActivity.class);
                startActivity(intent);
            }
        });



    }

    public void check() {

        starttext = String.valueOf(textView.getText());

        if (starttext.length()>0) {
            switch (starttext) {
                case "King Library":

                    buttonKing.setVisibility(View.VISIBLE);
                    buttonKing.setBackgroundResource(R.drawable.ic_red);

                    break;

                case "Engineering Building":

                    buttonEng.setVisibility(View.VISIBLE);
                    buttonEng.setBackgroundResource(R.drawable.ic_red);

                    break;
                case "Yoshihiro Uchida Hall":

                    buttonYUH.setVisibility(View.VISIBLE);
                    buttonYUH.setBackgroundResource(R.drawable.ic_red);

                    break;

                case "Student Union":

                    buttonSU.setVisibility(View.VISIBLE);
                    buttonSU.setBackgroundResource(R.drawable.ic_red);

                    break;

                case "BBC":

                    buttonBBC.setVisibility(View.VISIBLE);
                    buttonBBC.setBackgroundResource(R.drawable.ic_red);

                    break;

                case "South Parking Garage":

                    buttonGarage.setVisibility(View.VISIBLE);
                    buttonGarage.setBackgroundResource(R.drawable.ic_red);

                    break;


            }
        } else {

            buttonKing.setVisibility(View.VISIBLE);
            buttonKing.setBackgroundColor(Color.TRANSPARENT);

            buttonEng.setVisibility(View.VISIBLE);
            buttonEng.setBackgroundColor(Color.TRANSPARENT);

            buttonSU.setVisibility(View.VISIBLE);
            buttonSU.setBackgroundColor(Color.TRANSPARENT);

            buttonYUH.setVisibility(View.VISIBLE);
            buttonYUH.setBackgroundColor(Color.TRANSPARENT);

            buttonGarage.setVisibility(View.VISIBLE);
            buttonGarage.setBackgroundColor(Color.TRANSPARENT);

            buttonBBC.setVisibility(View.VISIBLE);
            buttonBBC.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == ACCESS_LOCATION_REQUEST_CODE) {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED) {

                // permission granted !
                // save the location !

                saveLocation();

            } else {
                // permission denied !
            }
        }
    }

    private void saveLocation() {


        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},ACCESS_LOCATION_REQUEST_CODE);
            return;

        }

        lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

        if(lastLocation != null) {

            latitude = String.valueOf(lastLocation.getLatitude());
            longitude = String.valueOf(lastLocation.getLongitude());

            Log.i(TAG, "saveLocation: lat = "+latitude);
            Log.i(TAG, "saveLocation: longitude = "+longitude);

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(getString(R.string.location_services_lat),latitude);
            editor.putString(getString(R.string.location_services_long),longitude);
            editor.commit();

        } else {
            Log.i(TAG, "saveLocation: lastlocation is null");
        }


    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        saveLocation();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void setViews() {

        buttonBBC = (Button) findViewById(R.id.button_bbc);
        buttonEng = (Button) findViewById(R.id.button_engg);
        buttonGarage = (Button) findViewById(R.id.button_garage);
        buttonSU = (Button) findViewById(R.id.button_su);
        buttonYUH = (Button) findViewById(R.id.button_yuh);
        buttonKing = (Button) findViewById(R.id.button_king);


        buttonKing.setVisibility(View.VISIBLE);
        buttonKing.setBackgroundColor(Color.TRANSPARENT);

        buttonEng.setVisibility(View.VISIBLE);
        buttonEng.setBackgroundColor(Color.TRANSPARENT);

        buttonGarage.setVisibility(View.VISIBLE);
        buttonGarage.setBackgroundColor(Color.TRANSPARENT);

        buttonSU.setVisibility(View.VISIBLE);
        buttonSU.setBackgroundColor(Color.TRANSPARENT);

        buttonYUH.setVisibility(View.VISIBLE);
        buttonYUH.setBackgroundColor(Color.TRANSPARENT);

        buttonBBC.setVisibility(View.VISIBLE);
        buttonBBC.setBackgroundColor(Color.TRANSPARENT);


    }

    public void actionBarSetUp(){
        ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(
                R.layout.custom_action_bar,null
        );

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(actionBarLayout);
    }

    public void googleApiClientSetUp(){
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
    }
}
