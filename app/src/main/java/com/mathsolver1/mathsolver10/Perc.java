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

public class Perc extends AppCompatActivity {

    private static EditText percn1;
    private static EditText percn2;
    private static Button percEqual;
    private static TextView percResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perc);

        percn1 = (EditText)findViewById(R.id.percn1);
        percn2 = (EditText)findViewById(R.id.percn2);
        percEqual = (Button)findViewById(R.id.percEqual);
        percResult = (TextView)findViewById(R.id.percResult);

        // Event Listener for percEqual
        percEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        percEqualClicked(v);
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
                Intent formInt = new Intent(Perc.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Perc.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Perc.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void percEqualClicked(View view) {
        percResult.setText("");
        if (percn1.getText().toString().equals("") || percn2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = percn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = percn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            float n3;
            n3 = n2 * (n1/100);
            percResult.setText("Result: " + n3);
        }

    }

}