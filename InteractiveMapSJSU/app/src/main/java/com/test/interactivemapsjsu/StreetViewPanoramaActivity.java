package com.test.interactivemapsjsu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.StreetViewPanoramaView;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;

/**
 * Created by NehaRege on 10/27/16.
 */
public class StreetViewPanoramaActivity extends AppCompatActivity {

    String TAG = "PanoramaActivity";

//    StreetViewPanoramaOptions options;




    private static final LatLng ENGG = new LatLng(37.335142,-121.881276);
    private static final LatLng KING = new LatLng(37.335142,-121.881276);
    private static final LatLng GARAGE = new LatLng(37.335142,-121.881276);
    private static final LatLng BBC = new LatLng(37.335142,-121.881276);
    private static final LatLng SU = new LatLng(37.335142,-121.881276);
    private static final LatLng YUH = new LatLng(37.335142,-121.881276);

    private static final LatLng SYDNEY = new LatLng(37.333474,-121.879916);

    private StreetViewPanoramaView mStreetViewPanoramaView;

    private static final String STREETVIEW_BUNDLE_KEY = "StreetViewBundleKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        StreetViewPanoramaOptions options = new StreetViewPanoramaOptions();

        if (savedInstanceState == null) {

            if(intent.getStringExtra("key_garage") != null && intent.getStringExtra("key_garage").equals("garage")) {

                options.position(SYDNEY);

            } else if (intent.getStringExtra("key_su") != null && intent.getStringExtra("key_su").equals("su")){

                options.position(SU);


            } else if (intent.getStringExtra("key_yuh") != null && intent.getStringExtra("key_yuh").equals("yuh")) {
                options.position(YUH);


            } else if (intent.getStringExtra("key_bbc") != null && intent.getStringExtra("key_bbc").equals("bbc")) {
                options.position(BBC);


            } else if(intent.getStringExtra("key_engg") != null && intent.getStringExtra("key_engg").equals("engg")) {
                options.position(ENGG);

            } else if(intent.getStringExtra("key_king") != null && intent.getStringExtra("key_king").equals("king")) {

                options.position(KING);
            }


        }


        Log.i(TAG, "onCreate: intent = "+intent.getStringExtra("key_engg"));

//        if(intent.getStringExtra("key_garage").equals("garage")) {
//            options = new StreetViewPanoramaOptions();
//
//            if (savedInstanceState == null) {
//                options.position(GARAGE);
//            }
//
//        } else if (intent.getStringExtra("key_su").equals("su")){
//            options = new StreetViewPanoramaOptions();
//
//            if (savedInstanceState == null) {
//                options.position(SU);
//            }
//
//        } else if (intent.getStringExtra("key_yuh").equals("yuh")) {
//            options = new StreetViewPanoramaOptions();
//
//            if (savedInstanceState == null) {
//                options.position(YUH);
//            }
//        } else if (intent.getStringExtra("key_bbc").equals("bbc")) {
//            options = new StreetViewPanoramaOptions();
//
//            if (savedInstanceState == null) {
//                options.position(BBC);
//            }
//        } else if(intent.getStringExtra("key_engg").equals("engg")) {
//            options = new StreetViewPanoramaOptions();
//
//            if (savedInstanceState == null) {
//                options.position(ENGG);
//            }
//        } else if(intent.getStringExtra("key_king").equals("king")) {
//            options = new StreetViewPanoramaOptions();
//
//            if (savedInstanceState == null) {
//                options.position(KING);
//            }
//        }


//        if (savedInstanceState == null) {
//            options.position(SYDNEY);
//        }

        mStreetViewPanoramaView = new StreetViewPanoramaView(this, options);
        addContentView(mStreetViewPanoramaView,
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        Bundle mStreetViewBundle = null;
        if (savedInstanceState != null) {
            mStreetViewBundle = savedInstanceState.getBundle(STREETVIEW_BUNDLE_KEY);
        }
        mStreetViewPanoramaView.onCreate(mStreetViewBundle);
    }

    @Override
    protected void onResume() {
        mStreetViewPanoramaView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mStreetViewPanoramaView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mStreetViewPanoramaView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mStreetViewBundle = outState.getBundle(STREETVIEW_BUNDLE_KEY);
        if (mStreetViewBundle == null) {
            mStreetViewBundle = new Bundle();
            outState.putBundle(STREETVIEW_BUNDLE_KEY, mStreetViewBundle);
        }

        mStreetViewPanoramaView.onSaveInstanceState(mStreetViewBundle);
    }
}
