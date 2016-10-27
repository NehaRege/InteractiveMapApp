package com.test.interactivemapsjsu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by NehaRege on 10/27/16.
 */
public class StreetViewActivity extends AppCompatActivity {

    ImageView imageViewStreet;



    private static String imageURL =
            "https://maps.googleapis.com/maps/api/streetview?size=400x400&location=40.720032,-73.988354&fov=120&heading=360&pitch=10&key=AIzaSyBUfIU0Ilra4TNEB7w0Em5wNy1i-y3htdA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_street_view);

        imageViewStreet = (ImageView) findViewById(R.id.street_view_img);

        Picasso.with(this).load(imageURL).into(imageViewStreet);

//        Picasso.with(this).load(imageURL).into(imageView);





    }
}
