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

public class Div extends AppCompatActivity {

    private static EditText divn1;
    private static EditText divn2;
    private static Button divEqual;
    private static TextView divResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.div);

        divn1 = (EditText)findViewById(R.id.divn1);
        divn2 = (EditText)findViewById(R.id.divn2);
        divEqual = (Button)findViewById(R.id.divEqual);
        divResult = (TextView)findViewById(R.id.divResult);

        // Event Listener for divEqual
        divEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        divEqualClicked(v);
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
                Intent formInt = new Intent(Div.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Div.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Div.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void divEqualClicked(View view) {
        divResult.setText("");
        if (divn1.getText().toString().equals("") || divn2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = divn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = divn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            float n3;
            n3 = n1 / n2;
            divResult.setText("Result: " + n3);
        }

    }

}