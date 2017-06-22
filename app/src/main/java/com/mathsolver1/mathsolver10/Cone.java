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

public class Cone extends AppCompatActivity {

    private static EditText conen1;
    private static EditText conen2;
    private static Button coneEqual;
    private static TextView coneResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cone);

        conen1 = (EditText)findViewById(R.id.conen1);
        conen2 = (EditText)findViewById(R.id.conen2);
        coneEqual = (Button)findViewById(R.id.coneEqual);
        coneResult = (TextView)findViewById(R.id.coneResult);

        // Event Listener for coneEqual
        coneEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        coneEqualClicked(v);
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
                Intent formInt = new Intent(Cone.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Cone.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Cone.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void coneEqualClicked(View view) {
        coneResult.setText("");
        if (conen1.getText().toString().equals("") || conen2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = conen1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = conen2.getText().toString();
            float n2 = Float.valueOf(n2s);
            double n3;
            n3 = Math.PI * n1 * n1 * (n2 / 3);
            coneResult.setText("Volume fo the cone: " + n3);
        }

    }

}