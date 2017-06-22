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

public class Cube extends AppCompatActivity {

    private static EditText cuben1;
    private static Button cubeEqual;
    private static TextView cubeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cube);

        cuben1 = (EditText)findViewById(R.id.cuben1);
        cubeEqual = (Button)findViewById(R.id.cubeEqual);
        cubeResult = (TextView)findViewById(R.id.cubeResult);

        // Event Listener for cubeEqual
        cubeEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        cubeEqualClicked(v);
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
                Intent formInt = new Intent(Cube.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Cube.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Cube.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void cubeEqualClicked(View view) {
        cubeResult.setText("");
        if (cuben1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = cuben1.getText().toString();
            float n1 = Float.valueOf(n1s);
            cubeResult.setText("Volume of the cube: " + (n1 * n1 * n1));
        }

    }

}