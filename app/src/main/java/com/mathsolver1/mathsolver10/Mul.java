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

public class Mul extends AppCompatActivity {

    private static EditText muln1;
    private static EditText muln2;
    private static Button mulEqual;
    private static TextView mulResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mul);

        muln1 = (EditText)findViewById(R.id.muln1);
        muln2 = (EditText)findViewById(R.id.muln2);
        mulEqual = (Button)findViewById(R.id.mulEqual);
        mulResult = (TextView)findViewById(R.id.mulResult);

        // Event Listener for mulEqual
        mulEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        mulEqualClicked(v);
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
                Intent formInt = new Intent(Mul.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Mul.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Mul.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void mulEqualClicked(View view) {
        mulResult.setText("");
        if (muln1.getText().toString().equals("") || muln2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = muln1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = muln2.getText().toString();
            float n2 = Float.valueOf(n2s);
            float n3;
            n3 = n1 * n2;
            mulResult.setText("Result: " + n3);
        }

    }

}