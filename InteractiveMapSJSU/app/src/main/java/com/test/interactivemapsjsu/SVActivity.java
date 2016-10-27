package com.test.interactivemapsjsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by NehaRege on 10/26/16.
 */
public class SVActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);


        supportStreetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

//        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
//        mMap.addMarker(new MarkerOptions().position(new LatLng(33.748832, -84.38751300000001)).title("Marker"));
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//        mMap.setTrafficEnabled(true);
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//                .zoom(17)                   // Sets the zoom
//                .target(new LatLng(33.748832, -84.38751300000001))
//                .bearing(90)                // Sets the orientation of the camera to east
//                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
//                .build();                   // Creates a CameraPosition from the builder
//        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        Intent intent = getIntent();



    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {

        streetViewPanorama.setPosition(new LatLng(19.024440,72.867056));


    }
}
