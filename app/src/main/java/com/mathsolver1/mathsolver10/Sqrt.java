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

public class Sqrt extends AppCompatActivity {

    private static EditText sqrtn1;
    private static Button sqrtEqual;
    private static TextView sqrtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqrt);

        sqrtn1 = (EditText) findViewById(R.id.sqrtn1);
        sqrtEqual = (Button) findViewById(R.id.sqrtEqual);
        sqrtResult = (TextView) findViewById(R.id.sqrtResult);

        // Event Listener for sqrtEqual
        sqrtEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        sqrtEqualClicked(v);
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
                Intent formInt = new Intent(Sqrt.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Sqrt.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Sqrt.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sqrtEqualClicked(View view) {
        sqrtResult.setText("");
        if (sqrtn1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        } else {
            String n1s = sqrtn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            sqrtResult.setText("Result: " + Math.sqrt(n1));
        }

    }

}