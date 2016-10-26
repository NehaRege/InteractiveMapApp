package com.test.interactivemapsjsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by NehaRege on 10/25/16.
 */
public class KingActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewAdd;
    private TextView textViewTime;
    private TextView textViewDist;

    private Button buttonStreetView;

    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_detail);

        setViews();

        Intent intent = getIntent();

        if(intent.getStringExtra("king_key").equals("king")) {

            textViewName.setText("King Library");
            textViewAdd.setText("Dr. Martin Luther King, Jr. Library, 150 East San Fernando Street, San Jose, CA 95112");
            image.setImageResource(R.drawable.campusmap);

        }



    }

    public void setViews() {

        textViewName = (TextView) findViewById(R.id.detail_name);
        textViewAdd = (TextView) findViewById(R.id.detail_address);
        textViewTime = (TextView) findViewById(R.id.detail_travel_time);
        textViewDist = (TextView) findViewById(R.id.detail_travel_distance);
        buttonStreetView = (Button) findViewById(R.id.detail_button_street_view);
        image = (ImageView) findViewById(R.id.detail_building_pic);


    }
}
