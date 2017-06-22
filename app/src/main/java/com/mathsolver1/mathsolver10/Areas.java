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

public class Areas extends AppCompatActivity {

    private static Button squareButton;
    private static Button circleButton;
    private static Button triangleButton;
    private static Button rectangleButton;
    private static Button trapezoidButton;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.areas);

        // Ads
        MobileAds.initialize(this, "ca-app-pub-4469511270900382~4345148756");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        squareButton = (Button)findViewById(R.id.squareButton);
        circleButton = (Button)findViewById(R.id.circleButton);
        triangleButton = (Button)findViewById(R.id.triangleButton);
        rectangleButton = (Button)findViewById(R.id.rectangleButton);
        trapezoidButton = (Button)findViewById(R.id.trapezoidButton);

        // Event Listener for squareEqual
        squareButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "square");
                    }
                }
        );

        // Event Listener for circleEqual
        circleButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "circle");
                    }
                }
        );

        // Event Listener for triangleEqual
        triangleButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "triangle");
                    }
                }
        );

        // Event Listener for rectangleEqual
        rectangleButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "rectangle");
                    }
                }
        );

        // Event Listener for trapezoidEqual
        trapezoidButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "trapezoid");
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
                Intent formInt = new Intent(Areas.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Areas.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Areas.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void op(View view, String op) {
        switch (op) {
            case "square":
                Intent addInt = new Intent(Areas.this, Square.class);
                startActivity(addInt);
                break;
            case "circle":
                Intent subInt = new Intent(Areas.this, Circle.class);
                startActivity(subInt);
                break;
            case "triangle":
                Intent mulInt = new Intent(Areas.this, Triangle.class);
                startActivity(mulInt);
                break;
            case "rectangle":
                Intent divInt = new Intent(Areas.this, Rect.class);
                startActivity(divInt);
                break;
            case "trapezoid":
                Intent modInt = new Intent(Areas.this, Trapezoid.class);
                startActivity(modInt);
                break;
        }
    }

}