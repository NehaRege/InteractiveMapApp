package com.test.interactivemapsjsu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.interactivemapsjsu.APIService.APIService;
import com.test.interactivemapsjsu.Model.TimeDistanceModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NehaRege on 10/25/16.
 */
public class KingActivity extends AppCompatActivity {

    String TAG = "KingActivity";


    private TextView textViewName;
    private TextView textViewAdd;
    private TextView textViewTime;
    private TextView textViewDist;

    private Button buttonStreetView;

    private ImageView image;

    private String lat;
    private String longi;

    private String currLocation;

    private String duration;
    private String distance;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_detail);

        initializeViews();

        Intent intent = getIntent();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        lat = sharedPreferences.getString(getString(R.string.location_services_lat),null);
        longi = sharedPreferences.getString(getString(R.string.location_services_long),null);

        currLocation = lat+","+longi;

        Log.i(TAG, "****** onCreate: KING Activity ******");
        Log.i(TAG, "onCreate: lat = "+lat);
        Log.i(TAG, "onCreate: longi = "+longi);

        Log.i(TAG, "onCreate: currLocation variable = "+currLocation);

        loadDistTimeEngg(currLocation);

        Log.i(TAG, "onCreate: loaddisttime function completed");

        if(intent.getStringExtra("king_key").equals("king")) {

            Log.i(TAG, "onCreate: setting text");

            textViewName.setText(R.string.library_name);
            textViewAdd.setText(R.string.library_address);
            image.setImageResource(R.drawable.library);

            Log.i(TAG, "onCreate: before set text --------");
            Log.i(TAG, "onCreate: duration = "+duration);
            Log.i(TAG, "onCreate: distance = "+distance);


        }



    }

    public void initializeViews() {

        textViewName = (TextView) findViewById(R.id.detail_name);
        textViewAdd = (TextView) findViewById(R.id.detail_address);
        textViewTime = (TextView) findViewById(R.id.detail_travel_time);
        textViewDist = (TextView) findViewById(R.id.detail_travel_distance);
        buttonStreetView = (Button) findViewById(R.id.detail_button_street_view);
        image = (ImageView) findViewById(R.id.detail_building_pic);


    }

    public void loadDistTimeEngg(String currLocation) {
        Log.i(TAG, "loadDistTimeEngg: inside the function");
        String BASE_URL = "https://maps.googleapis.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService request = retrofit.create(APIService.class);
        Call<TimeDistanceModel> call = request.getTimeDistKing(currLocation);
        call.enqueue(new Callback<TimeDistanceModel>() {
            @Override
            public void onResponse(Call<TimeDistanceModel> call, Response<TimeDistanceModel> response) {
                try {
                    TimeDistanceModel timeDistModel = response.body();
                    distance = timeDistModel.getRows().get(0).getElements().get(0).getDistance().getText();
                    duration = timeDistModel.getRows().get(0).getElements().get(0).getDuration().getText();

                    Log.i(TAG, "onResponse: distance = "+distance);
                    Log.i(TAG, "onResponse: duration = "+duration);

                    textViewDist.setText(distance);
                    textViewTime.setText(duration);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TimeDistanceModel> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });








    }
}
