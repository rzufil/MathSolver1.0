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

public class Cylinder extends AppCompatActivity {

    private static EditText cylindern1;
    private static EditText cylindern2;
    private static Button cylinderEqual;
    private static TextView cylinderResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cylinder);

        cylindern1 = (EditText)findViewById(R.id.cylindern1);
        cylindern2 = (EditText)findViewById(R.id.cylindern2);
        cylinderEqual = (Button)findViewById(R.id.cylinderEqual);
        cylinderResult = (TextView)findViewById(R.id.cylinderResult);

        // Event Listener for cylinderEqual
        cylinderEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        cylinderEqualClicked(v);
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
                Intent formInt = new Intent(Cylinder.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Cylinder.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Cylinder.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void cylinderEqualClicked(View view) {
        cylinderResult.setText("");
        if (cylindern1.getText().toString().equals("") || cylindern2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = cylindern1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = cylindern2.getText().toString();
            float n2 = Float.valueOf(n2s);
            double n3;
            n3 = Math.PI * n1 * n1 * n2;
            cylinderResult.setText("Volume of the cylinder: " + n3);
        }

    }

}