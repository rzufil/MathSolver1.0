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

public class Mod extends AppCompatActivity {

    private static EditText modn1;
    private static EditText modn2;
    private static Button modEqual;
    private static TextView modResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mod);

        modn1 = (EditText)findViewById(R.id.modn1);
        modn2 = (EditText)findViewById(R.id.modn2);
        modEqual = (Button)findViewById(R.id.modEqual);
        modResult = (TextView)findViewById(R.id.modResult);

        // Event Listener for modEqual
        modEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        modEqualClicked(v);
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
                Intent formInt = new Intent(Mod.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Mod.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Mod.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void modEqualClicked(View view) {
        modResult.setText("");
        if (modn1.getText().toString().equals("") || modn2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = modn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = modn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            float n3;
            n3 = n1 % n2;
            modResult.setText("Result: " + n3);
        }

    }

}