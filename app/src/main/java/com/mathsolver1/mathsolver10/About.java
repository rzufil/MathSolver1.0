package com.mathsolver1.mathsolver10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private static TextView aboutText;
    private static TextView aboutText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        aboutText = (TextView)findViewById(R.id.aboutText);
        aboutText2 = (TextView)findViewById(R.id.aboutText2);

        aboutText.setText("Math Solver 1.0 is a free Android application that solves simple math operations. It is designed and maintained by Rafael Leite." +
                " It is a work in progress, and new functionalities will be added in future updates.\n\nTo learn more about the app and past updates visit our website:");

        aboutText2.setText("\nVersion 1.0");
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
                Intent formulasInt = new Intent(About.this, Formulas.class);
                startActivity(formulasInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(About.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}