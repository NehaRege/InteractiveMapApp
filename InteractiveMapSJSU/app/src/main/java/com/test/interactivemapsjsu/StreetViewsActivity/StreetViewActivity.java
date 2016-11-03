package com.test.interactivemapsjsu.StreetViewsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.test.interactivemapsjsu.R;

/**
 * Created by NehaRege on 10/27/16.
 */
public class StreetViewActivity extends AppCompatActivity {

    String TAG = "StreetViewActivity";

    ImageView imageViewStreet;

    private String imageURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_street_view);

        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(true);

        }

        imageViewStreet = (ImageView) findViewById(R.id.street_view_img);

        Intent intent = getIntent();

        if(intent.getStringExtra("key_engg") != null && intent.getStringExtra("key_engg").equals("engg")) {

            imageURL = "https://maps.googleapis.com/maps/api/streetview?size=1000x500&location=37.335142,-121.881276&fov=100&heading=45&pitch=5&key=AIzaSyBUfIU0Ilra4TNEB7w0Em5wNy1i-y3htdA";
            Picasso.with(this).load(imageURL).into(imageViewStreet);

        } else if(intent.getStringExtra("key_garage") != null && intent.getStringExtra("key_garage").equals("garage")) {

            imageURL = "https://maps.googleapis.com/maps/api/streetview?size=1000x500&location=37.333474,-121.879916&fov=90&heading=151.78&pitch=5&key=AIzaSyBUfIU0Ilra4TNEB7w0Em5wNy1i-y3htdA";

            Picasso.with(this).load(imageURL).into(imageViewStreet);


        } else if (intent.getStringExtra("key_su") != null && intent.getStringExtra("key_su").equals("su")){

            imageURL = "https://maps.googleapis.com/maps/api/streetview?size=1000x500&location=37.424197,-122.170939&fov=100&heading=45&pitch=5&key=AIzaSyBUfIU0Ilra4TNEB7w0Em5wNy1i-y3htdA";
            Picasso.with(this).load(imageURL).into(imageViewStreet);

        } else if (intent.getStringExtra("key_yuh") != null && intent.getStringExtra("key_yuh").equals("yuh")) {

            imageURL = "https://maps.googleapis.com/maps/api/streetview?size=1000x500&location=37.333770,-121.883388&fov=100&heading=45&pitch=5&key=AIzaSyBUfIU0Ilra4TNEB7w0Em5wNy1i-y3htdA";
            Picasso.with(this).load(imageURL).into(imageViewStreet);

        } else if (intent.getStringExtra("key_bbc") != null && intent.getStringExtra("key_bbc").equals("bbc")) {

            imageURL = "https://maps.googleapis.com/maps/api/streetview?size=1000x500&location=37.336561,-121.878723&fov=100&heading=45&pitch=5&key=AIzaSyBUfIU0Ilra4TNEB7w0Em5wNy1i-y3htdA";
            Picasso.with(this).load(imageURL).into(imageViewStreet);

        }  else if(intent.getStringExtra("key_king") != null && intent.getStringExtra("key_king").equals("king")) {

            imageURL = "https://maps.googleapis.com/maps/api/streetview?size=1000x500&location=37.335507,-121.884999&fov=100&heading=45&pitch=5&key=AIzaSyBUfIU0Ilra4TNEB7w0Em5wNy1i-y3htdA";
            Picasso.with(this).load(imageURL).into(imageViewStreet);

        }
    }
}
