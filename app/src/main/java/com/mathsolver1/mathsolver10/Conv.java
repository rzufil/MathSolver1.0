package com.mathsolver1.mathsolver10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Conv extends AppCompatActivity {

    private static Button temperatureButton;
    private static Button lengthButton;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conv);

        // Ads
        MobileAds.initialize(this, "ca-app-pub-4469511270900382~4345148756");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        temperatureButton = (Button)findViewById(R.id.temperatureButton);
        lengthButton = (Button)findViewById(R.id.lengthButton);

        // Event Listener for temperatureEqual
        temperatureButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "temperature");
                    }
                }
        );

        // Event Listener for lengthEqual
        lengthButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "length");
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.formulas:
                Intent formInt = new Intent(Conv.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Conv.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Conv.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void op(View view, String op) {
        switch (op) {
            case "temperature":
                Intent temperatureInt = new Intent(Conv.this, Temperature.class);
                startActivity(temperatureInt);
                break;
            case "length":
                Intent lengthInt = new Intent(Conv.this, Length.class);
                startActivity(lengthInt);
                break;
        }
    }

}