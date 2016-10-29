package com.test.interactivemapsjsu.BuildingActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.interactivemapsjsu.APIService.APIService;
import com.test.interactivemapsjsu.Model.TimeDistanceModel;
import com.test.interactivemapsjsu.R;
import com.test.interactivemapsjsu.StreetViewActivity;
import com.test.interactivemapsjsu.StreetViewPanoramaActivity;
import com.test.interactivemapsjsu.SvActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NehaRege on 10/26/16.
 */
public class EnggActivity extends AppCompatActivity {

    String TAG = "EnggActivity";

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
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);

        }

        Intent intent = getIntent();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        lat = sharedPreferences.getString(getString(R.string.location_services_lat),null);
        longi = sharedPreferences.getString(getString(R.string.location_services_long),null);
        currLocation = lat+","+longi;

        loadDistTimeEngg(currLocation);


        textViewName.setText(R.string.engineering_building_name);
        textViewAdd.setText(R.string.engg_building_address);
        image.setImageResource(R.drawable.eng);


        buttonStreetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(EnggActivity.this,StreetViewPanoramaActivity.class);
                intent1.putExtra("key_engg","engg");
                startActivity(intent1);
            }
        });


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

        String BASE_URL = "https://maps.googleapis.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService request = retrofit.create(APIService.class);
        Call<TimeDistanceModel> call = request.getTimeDistEngg(currLocation);
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
