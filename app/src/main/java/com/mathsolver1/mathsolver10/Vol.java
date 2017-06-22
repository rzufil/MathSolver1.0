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

public class Vol extends AppCompatActivity {

    private static Button cubeButton;
    private static Button cylinderButton;
    private static Button pyramidButton;
    private static Button coneButton;
    private static Button sphereButton;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vol);

        // Ads
        MobileAds.initialize(this, "ca-app-pub-4469511270900382~4345148756");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        cubeButton = (Button)findViewById(R.id.cubeButton);
        cylinderButton = (Button)findViewById(R.id.cylinderButton);
        pyramidButton = (Button)findViewById(R.id.pyramidButton);
        coneButton = (Button)findViewById(R.id.coneButton);
        sphereButton = (Button)findViewById(R.id.sphereButton);

        // Event Listener for cubeEqual
        cubeButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "cube");
                    }
                }
        );

        // Event Listener for cylinderEqual
        cylinderButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "cylinder");
                    }
                }
        );

        // Event Listener for pyramidEqual
        pyramidButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "pyramid");
                    }
                }
        );

        // Event Listener for coneEqual
        coneButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "cone");
                    }
                }
        );

        // Event Listener for sphereEqual
        sphereButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "sphere");
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
                Intent formInt = new Intent(Vol.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Vol.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Vol.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void op(View view, String op) {
        switch (op) {
            case "cube":
                Intent cubeInt = new Intent(Vol.this, Cube.class);
                startActivity(cubeInt);
                break;
            case "cylinder":
                Intent cylinderInt = new Intent(Vol.this, Cylinder.class);
                startActivity(cylinderInt);
                break;
            case "pyramid":
                Intent pyramidInt = new Intent(Vol.this, Pyramid.class);
                startActivity(pyramidInt);
                break;
            case "cone":
                Intent coneInt = new Intent(Vol.this, Cone.class);
                startActivity(coneInt);
                break;
            case "sphere":
                Intent sphereInt = new Intent(Vol.this, Sphere.class);
                startActivity(sphereInt);
                break;
        }
    }

}