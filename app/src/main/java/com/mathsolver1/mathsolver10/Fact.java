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

public class Fact extends AppCompatActivity {

    private static EditText factn1;
    private static Button factEqual;
    private static TextView factResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fact);

        factn1 = (EditText) findViewById(R.id.factn1);
        factEqual = (Button) findViewById(R.id.factEqual);
        factResult = (TextView) findViewById(R.id.factResult);

        // Event Listener for factEqual
        factEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        factEqualClicked(v);
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
                Intent formInt = new Intent(Fact.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Fact.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Fact.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void factEqualClicked(View view) {
        factResult.setText("");
        if (factn1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        } else {
            String n1s = factn1.getText().toString();
            int n1 = Integer.parseInt(n1s);
            int n2 = fact(n1);
            factResult.setText("Result: " + n2);
        }

    }

    public int fact(int n1) {
        if (n1 == 0) {
            return 1;
        }
        if (n1 > 0) {
            n1 = n1 * fact(n1 - 1);
        }
        return n1;
    }

}