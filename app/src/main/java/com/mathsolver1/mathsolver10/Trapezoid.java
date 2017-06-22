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

public class Trapezoid extends AppCompatActivity {

    private static EditText trapezoidn1;
    private static EditText trapezoidn2;
    private static EditText trapezoidn3;
    private static Button trapezoidEqual;
    private static TextView trapezoidResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trapezoid);

        trapezoidn1 = (EditText)findViewById(R.id.trapezoidn1);
        trapezoidn2 = (EditText)findViewById(R.id.trapezoidn2);
        trapezoidn3 = (EditText)findViewById(R.id.trapezoidn3);
        trapezoidEqual = (Button)findViewById(R.id.trapezoidEqual);
        trapezoidResult = (TextView)findViewById(R.id.trapezoidResult);

        // Event Listener for trapezoidEqual
        trapezoidEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        trapezoidEqualClicked(v);
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
                Intent formInt = new Intent(Trapezoid.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Trapezoid.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Trapezoid.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void trapezoidEqualClicked(View view) {
        trapezoidResult.setText("");
        if (trapezoidn1.getText().toString().equals("") || trapezoidn2.getText().toString().equals("") || trapezoidn3.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = trapezoidn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = trapezoidn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            String n3s = trapezoidn3.getText().toString();
            float n3 = Float.valueOf(n3s);
            double n4;
            if(n1 > n2) {
                Toast.makeText(getApplicationContext(), "The first number is not the smallest horizontal side of the trapezoid!", Toast.LENGTH_LONG).show();
            }
            else {
                if (n1 == n2) {
                    if (n1 == n3) {
                        n4 = n1 * n2;
                        trapezoidResult.setText("It looks like you input the dimensions of a square. Here is the area of your square: " + n4);
                    }
                    else {
                        n4 = n1 * n3;
                        trapezoidResult.setText("It looks like you input the dimensions of a rectangle. Here is the area of your rectangle: " + n4);
                    }
                }
                else {
                    n4 = ((n1 + n2)/2) * n3;
                    trapezoidResult.setText("Area of the trapezoid: " + n4);
                }
            }
        }

    }

}