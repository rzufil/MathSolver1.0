package com.mathsolver1.mathsolver10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Temperature extends AppCompatActivity {

    private static EditText temperaturen1;
    private static Spinner fromTempSpinner;
    private static Spinner toTempSpinner;
    private static Button temperatureEqual;
    private static TextView temperatureResult;
    private static String fromTemp;
    private static String toTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);

        temperaturen1 = (EditText)findViewById(R.id.temperaturen1);
        fromTempSpinner = (Spinner)findViewById(R.id.fromTempSpinner);
        toTempSpinner = (Spinner)findViewById(R.id.toTempSpinner);
        temperatureEqual = (Button)findViewById(R.id.temperatureEqual);
        temperatureResult = (TextView)findViewById(R.id.temperatureResult);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.temp, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        fromTempSpinner.setAdapter(staticAdapter);

        // Apply the adapter to the spinner
        toTempSpinner.setAdapter(staticAdapter);

        // Event Listener for fromTempSpinner
        fromTempSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromTemp = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                fromTemp = "";
            }
        });

        // Event Listener for toTempSpinner
        toTempSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toTemp = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                toTemp = "";
            }
        });

        // Event Listener for temperatureEqual
        temperatureEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        temperatureEqualClicked(v);
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
                Intent formInt = new Intent(Temperature.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Temperature.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Temperature.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void temperatureEqualClicked(View view) {
        temperatureResult.setText("");
        if (temperaturen1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a temperature!", Toast.LENGTH_LONG).show();
        }
        else if (fromTemp.equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to select a \"From\" temperature!", Toast.LENGTH_LONG).show();
        }
        else if (toTemp.equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to select a \"To\" temperature!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = temperaturen1.getText().toString();
            float n1 = Float.valueOf(n1s);
            double n2;
            switch (fromTemp) {
                case "Celsius":
                    switch (toTemp) {
                        case "Celsius":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" temperature!", Toast.LENGTH_LONG).show();
                            break;
                        case "Fahrenheit":
                            n2 = ((n1 * 9)/5) + 32;
                            temperatureResult.setText("Result: " + n1 + " \u00b0C = " + n2 + " \u00b0F");
                            break;
                        case "Kelvin":
                            n2 = n1 + 273.15;
                            temperatureResult.setText("Result: " + n1 + " \u00b0C = " + n2 + " K");
                            break;
                    }
                    break;
                case "Fahrenheit":
                    switch (toTemp) {
                        case "Celsius":
                            n2 = ((n1 - 32)*5)/9;
                            temperatureResult.setText("Result: " + n1 + " \u00b0F = " + n2 + " \u00b0C");
                            break;
                        case "Fahrenheit":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" temperature!", Toast.LENGTH_LONG).show();
                            break;
                        case "Kelvin":
                            n2 = (((n1 - 32)*5)/9) + 273.15;
                            temperatureResult.setText("Result: " + n1 + " \u00b0F = " + n2 + " K");
                            break;
                    }
                    break;
                case "Kelvin":
                    switch (toTemp) {
                        case "Celsius":
                            n2 = n1 - 273.15;
                            temperatureResult.setText("Result: " + n1 + " K = " + n2 + " \u00b0C");
                            break;
                        case "Fahrenheit":
                            n2 = (((n1 - 273.15)*9)/5) + 32;
                            temperatureResult.setText("Result: " + n1 + " K = " + n2 + " \u00b0F");
                            break;
                        case "Kelvin":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" temperature!", Toast.LENGTH_LONG).show();
                            break;
                    }
                    break;
            }
        }

    }

}