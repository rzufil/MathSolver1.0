package com.mathsolver1.mathsolver10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sphere extends AppCompatActivity {

    private static EditText spheren1;
    private static Button sphereEqual;
    private static TextView sphereResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sphere);

        spheren1 = (EditText)findViewById(R.id.spheren1);
        sphereEqual = (Button)findViewById(R.id.sphereEqual);
        sphereResult = (TextView)findViewById(R.id.sphereResult);

        // Event Listener for sphereEqual
        sphereEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        sphereEqualClicked(v);
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
                Intent formInt = new Intent(Sphere.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Sphere.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Sphere.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sphereEqualClicked(View view) {
        sphereResult.setText("");
        if (spheren1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = spheren1.getText().toString();
            float n1 = Float.valueOf(n1s);
            double n2;
            n2 = (4 * Math.PI * n1 * n1 * n1)/3;
            sphereResult.setText("Volume of the sphere: " + n2);
        }

    }

}