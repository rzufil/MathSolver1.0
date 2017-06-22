package com.mathsolver1.mathsolver10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    private static TextView contactText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        contactText = (TextView)findViewById(R.id.contactText);

        contactText.setText("Click on the link below to contact us:");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent aboutInt = new Intent(Contact.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.formulas:
                Intent formulasInt = new Intent(Contact.this, Formulas.class);
                startActivity(formulasInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}