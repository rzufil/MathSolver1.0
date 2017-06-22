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

public class Exp extends AppCompatActivity {

    private static EditText expn1;
    private static EditText expn2;
    private static Button expEqual;
    private static TextView expResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp);

        expn1 = (EditText)findViewById(R.id.expn1);
        expn2 = (EditText)findViewById(R.id.expn2);
        expEqual = (Button)findViewById(R.id.expEqual);
        expResult = (TextView)findViewById(R.id.expResult);

        // Event Listener for expEqual
        expEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        expEqualClicked(v);
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
                Intent formInt = new Intent(Exp.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Exp.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Exp.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void expEqualClicked(View view) {
        expResult.setText("");
        if (expn1.getText().toString().equals("") || expn2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = expn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = expn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            double n3;
            n3 = Math.pow((double)n1, (double)n2);
            expResult.setText("Result: " + n3);
        }

    }

}