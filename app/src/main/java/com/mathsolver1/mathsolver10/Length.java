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

public class Length extends AppCompatActivity {

    private static EditText lengthn1;
    private static Spinner fromLengthSpinner;
    private static Spinner toLengthSpinner;
    private static Button lengthEqual;
    private static TextView lengthResult;
    private static String fromLength;
    private static String toLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length);

        lengthn1 = (EditText)findViewById(R.id.lengthn1);
        fromLengthSpinner = (Spinner)findViewById(R.id.fromLengthSpinner);
        toLengthSpinner = (Spinner)findViewById(R.id.toLengthSpinner);
        lengthEqual = (Button)findViewById(R.id.lengthEqual);
        lengthResult = (TextView)findViewById(R.id.lengthResult);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.len, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        fromLengthSpinner.setAdapter(staticAdapter);

        // Apply the adapter to the spinner
        toLengthSpinner.setAdapter(staticAdapter);

        // Event Listener for fromLengthSpinner
        fromLengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromLength = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                fromLength = "";
            }
        });

        // Event Listener for toLengthSpinner
        toLengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toLength = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                toLength = "";
            }
        });

        // Event Listener for lengthEqual
        lengthEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        lengthEqualClicked(v);
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
                Intent formInt = new Intent(Length.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Length.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Length.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void lengthEqualClicked(View view) {
        lengthResult.setText("");
        if (lengthn1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a length!", Toast.LENGTH_LONG).show();
        }
        else if (fromLength.equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to select a \"From\" length!", Toast.LENGTH_LONG).show();
        }
        else if (toLength.equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to select a \"To\" length!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = lengthn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            double n2;
            switch (fromLength) {
                case "Centimeter":
                    switch (toLength) {
                        case "Centimeter":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" length!", Toast.LENGTH_LONG).show();
                            break;
                        case "Meter":
                            n2 = n1/100D;
                            lengthResult.setText(n1 + "cm  = " + n2 + " m");
                            break;
                        case "Kilometer":
                            n2 = n1/100000D;
                            lengthResult.setText(n1 + " cm = " + n2 + " km");
                            break;
                        case "Inch":
                            n2 = n1/2.54;
                            lengthResult.setText(n1 + " cm = " + n2 + " in");
                            break;
                        case "Foot":
                            n2 = n1/30.48;
                            lengthResult.setText(n1 + " cm = " + n2 + " ft");
                            break;
                        case "Yard":
                            n2 = n1/91.44;
                            lengthResult.setText(n1 + " cm = " + n2 + " yard(s)");
                            break;
                        case "Mile":
                            n2 = n1/160934.4;
                            lengthResult.setText(n1 + " cm = " + n2 + " mile(s)");
                            break;
                    }
                    break;
                case "Meter":
                    switch (toLength) {
                        case "Centimeter":
                            n2 = n1*100D;
                            lengthResult.setText(n1 + " m = " + n2 + " cm");
                            break;
                        case "Meter":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" length!", Toast.LENGTH_LONG).show();
                            break;
                        case "Kilometer":
                            n2 = n1/1000D;
                            lengthResult.setText(n1 + " m = " + n2 + " km");
                            break;
                        case "Inch":
                            n2 = n1/0.0254;
                            lengthResult.setText(n1 + " m = " + n2 + " in");
                            break;
                        case "Foot":
                            n2 = n1/0.3048;
                            lengthResult.setText(n1 + " m = " + n2 + " ft");
                            break;
                        case "Yard":
                            n2 = n1/0.9144;
                            lengthResult.setText(n1 + " m = " + n2 + " yard(s)");
                            break;
                        case "Mile":
                            n2 = n1/1609.344;
                            lengthResult.setText(n1 + " m = " + n2 + " mile(s)");
                            break;
                    }
                    break;
                case "Kilometer":
                    switch (toLength) {
                        case "Centimeter":
                            n2 = n1*100000D;
                            lengthResult.setText(n1 + " km = " + n2 + " cm");
                            break;
                        case "Meter":
                            n2 = n1*1000D;
                            lengthResult.setText(n1 + " km = " + n2 + " m");
                            break;
                        case "Kilometer":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" length!", Toast.LENGTH_LONG).show();
                            break;
                        case "Inch":
                            n2 = n1/0.0000254;
                            lengthResult.setText(n1 + " km = " + n2 + " in");
                            break;
                        case "Foot":
                            n2 = n1/0.0003048;
                            lengthResult.setText(n1 + " km = " + n2 + " ft");
                            break;
                        case "Yard":
                            n2 = n1/0.0009144;
                            lengthResult.setText(n1 + " km = " + n2 + " yard(s)");
                            break;
                        case "Mile":
                            n2 = n1/1.609344;
                            lengthResult.setText(n1 + " km = " + n2 + " mile(s)");
                            break;
                    }
                    break;
                case "Inch":
                    switch (toLength) {
                        case "Centimeter":
                            n2 = n1*2.54;
                            lengthResult.setText(n1 + " in = " + n2 + " cm");
                            break;
                        case "Meter":
                            n2 = n1*0.0254;
                            lengthResult.setText(n1 + " in = " + n2 + " m");
                            break;
                        case "Kilometer":
                            n2 = n1*0.0000254;
                            lengthResult.setText(n1 + " in = " + n2 + " km");
                            break;
                        case "Inch":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" length!", Toast.LENGTH_LONG).show();
                            break;
                        case "Foot":
                            n2 = n1/12D;
                            lengthResult.setText(n1 + " in = " + n2 + " ft");
                            break;
                        case "Yard":
                            n2 = n1/36D;
                            lengthResult.setText(n1 + " in = " + n2 + " yard(s)");
                            break;
                        case "Mile":
                            n2 = n1/63360D;
                            lengthResult.setText(n1 + " in = " + n2 + " mile(s)");
                            break;
                    }
                    break;
                case "Foot":
                    switch (toLength) {
                        case "Centimeter":
                            n2 = n1*30.48;
                            lengthResult.setText(n1 + " ft = " + n2 + " cm");
                            break;
                        case "Meter":
                            n2 = n1*0.3048;
                            lengthResult.setText(n1 + " ft = " + n2 + " m");
                            break;
                        case "Kilometer":
                            n2 = n1*0.0003048;
                            lengthResult.setText(n1 + " ft = " + n2 + " km");
                            break;
                        case "Inch":
                            n2 = n1*12D;
                            lengthResult.setText(n1 + " ft = " + n2 + " in");
                            break;
                        case "Foot":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" length!", Toast.LENGTH_LONG).show();
                            break;
                        case "Yard":
                            n2 = n1/3D;
                            lengthResult.setText(n1 + " ft = " + n2 + " yard(s)");
                            break;
                        case "Mile":
                            n2 = n1/5280D;
                            lengthResult.setText(n1 + " ft = " + n2 + " mile(s)");
                            break;
                    }
                    break;
                case "Yard":
                    switch (toLength) {
                        case "Centimeter":
                            n2 = n1*91.44;
                            lengthResult.setText(n1 + " yard(s) = " + n2 + " cm");
                            break;
                        case "Meter":
                            n2 = n1*0.9144;
                            lengthResult.setText(n1 + " yard(s) = " + n2 + " m");
                            break;
                        case "Kilometer":
                            n2 = n1*0.0009144;
                            lengthResult.setText(n1 + " yard(s) = " + n2 + " km");
                            break;
                        case "Inch":
                            n2 = n1*36D;
                            lengthResult.setText(n1 + " yard(s) = " + n2 + " in");
                            break;
                        case "Foot":
                            n2 = n1*3D;
                            lengthResult.setText(n1 + " yard(s) = " + n2 + " ft");
                            break;
                        case "Yard":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" length!", Toast.LENGTH_LONG).show();
                            break;
                        case "Mile":
                            n2 = n1/1760D;
                            lengthResult.setText(n1 + " yard(s) = " + n2 + " mile(s)");
                            break;
                    }
                    break;
                case "Mile":
                    switch (toLength) {
                        case "Centimeter":
                            n2 = n1*160934.4;
                            lengthResult.setText(n1 + " mile(s) = " + n2 + " cm");
                            break;
                        case "Meter":
                            n2 = n1*1609.344;
                            lengthResult.setText(n1 + " mile(s) = " + n2 + " m");
                            break;
                        case "Kilometer":
                            n2 = n1*1.609344;
                            lengthResult.setText(n1 + " mile(s) = " + n2 + " km");
                            break;
                        case "Inch":
                            n2 = n1*63360D;
                            lengthResult.setText(n1 + " mile(s) = " + n2 + " in");
                            break;
                        case "Foot":
                            n2 = n1*5280D;
                            lengthResult.setText(n1 + " mile(s) = " + n2 + " ft");
                            break;
                        case "Yard":
                            n2 = n1*1760D;
                            lengthResult.setText(n1 + " mile(s) = " + n2 + " yard(s)");
                            break;
                        case "Mile":
                            Toast.makeText(getApplicationContext(), "Choose another \"To\" length!", Toast.LENGTH_LONG).show();
                            break;
                    }
                    break;
            }
        }

    }

}