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

public class Home extends AppCompatActivity {

    private static Button addButton;
    private static Button subButton;
    private static Button mulButton;
    private static Button divButton;
    private static Button modButton;
    private static Button factButton;
    private static Button sqrtButton;
    private static Button expButton;
    private static Button percButton;
    private static Button areaButton;
    private static Button volButton;
    private static Button convButton;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Ads
        MobileAds.initialize(this, "ca-app-pub-4469511270900382~4345148756");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        addButton = (Button)findViewById(R.id.addButton);
        subButton = (Button)findViewById(R.id.subButton);
        mulButton = (Button)findViewById(R.id.mulButton);
        divButton = (Button)findViewById(R.id.divButton);
        modButton = (Button)findViewById(R.id.modButton);
        factButton = (Button)findViewById(R.id.factButton);
        sqrtButton = (Button)findViewById(R.id.sqrtButton);
        expButton = (Button)findViewById(R.id.expButton);
        percButton = (Button)findViewById(R.id.percButton);
        areaButton = (Button)findViewById(R.id.areaButton);
        volButton = (Button)findViewById(R.id.volButton);
        convButton = (Button)findViewById(R.id.convButton);

        // Event Listener for addEqual
        addButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "add");
                    }
                }
        );

        // Event Listener for subEqual
        subButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "sub");
                    }
                }
        );

        // Event Listener for mulEqual
        mulButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "mul");
                    }
                }
        );

        // Event Listener for divEqual
        divButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "div");
                    }
                }
        );

        // Event Listener for modEqual
        modButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "mod");
                    }
                }
        );

        // Event Listener for factEqual
        factButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "fact");
                    }
                }
        );

        // Event Listener for sqrtEqual
        sqrtButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "sqrt");
                    }
                }
        );

        // Event Listener for expEqual
        expButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "exp");
                    }
                }
        );

        // Event Listener for percEqual
        percButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "perc");
                    }
                }
        );

        // Event Listener for areaEqual
        areaButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "area");
                    }
                }
        );

        // Event Listener for volEqual
        volButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "vol");
                    }
                }
        );

        // Event Listener for convEqual
        convButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        op(v, "conv");
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
                Intent formInt = new Intent(Home.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Home.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Home.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void op(View view, String op) {
        switch (op) {
            case "add":
                Intent addInt = new Intent(Home.this, Add.class);
                startActivity(addInt);
                break;
            case "sub":
                Intent subInt = new Intent(Home.this, Sub.class);
                startActivity(subInt);
                break;
            case "mul":
                Intent mulInt = new Intent(Home.this, Mul.class);
                startActivity(mulInt);
                break;
            case "div":
                Intent divInt = new Intent(Home.this, Div.class);
                startActivity(divInt);
                break;
            case "mod":
                Intent modInt = new Intent(Home.this, Mod.class);
                startActivity(modInt);
                break;
            case "fact":
                Intent factInt = new Intent(Home.this, Fact.class);
                startActivity(factInt);
                break;
            case "sqrt":
                Intent sqrtInt = new Intent(Home.this, Sqrt.class);
                startActivity(sqrtInt);
                break;
            case "exp":
                Intent expInt = new Intent(Home.this, Exp.class);
                startActivity(expInt);
                break;
            case "perc":
                Intent percInt = new Intent(Home.this, Perc.class);
                startActivity(percInt);
                break;
            case "area":
                Intent areaInt = new Intent(Home.this, Areas.class);
                startActivity(areaInt);
                break;
            case "vol":
                Intent volInt = new Intent(Home.this, Vol.class);
                startActivity(volInt);
                break;
            case "conv":
                Intent convInt = new Intent(Home.this, Conv.class);
                startActivity(convInt);
                break;
        }
    }

}