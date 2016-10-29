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
public class SvActivity extends AppCompatActivity {

    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);




    private static final LatLng ENGG = new LatLng(37.337274, -121.882982);
    private static final LatLng ENGG2 = new LatLng(37.337377, -121.882791);
    private static final LatLng KING = new LatLng(37.335949,-121.886004);
    private static final LatLng GARAGE = new LatLng(37.332705, -121.880304);
    private static final LatLng BBC = new LatLng(37.336905, -121.878202);
    private static final LatLng SU = new LatLng(37.337383, -121.882786);
    private static final LatLng YUH = new LatLng(37.333278, -121.883799);


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv);

        Intent intent = getIntent();


        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);


//        supportStreetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

        supportStreetViewPanoramaFragment.getStreetViewPanoramaAsync(new OnStreetViewPanoramaReadyCallback() {
            @Override
            public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
                if(savedInstanceState == null) {
                    streetViewPanorama.setPosition(ENGG);
                }
            }
        });




    }
}
