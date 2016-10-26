package com.test.interactivemapsjsu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonKing;
    private Button buttonEng;
    private Button buttonGarage;
    private Button buttonBBC;
    private Button buttonYUH;
    private Button buttonSU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setViews();

        buttonKing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "KING !!!!", Toast.LENGTH_SHORT).show();
            }
        });









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_search:

                Toast.makeText(MainActivity.this, "Searching !!!", Toast.LENGTH_SHORT).show();

                return true;

            default:


                return super.onOptionsItemSelected(item);

        }

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






    }
}
