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

public class Add extends AppCompatActivity {

    private static EditText addn1;
    private static EditText addn2;
    private static Button addEqual;
    private static TextView addResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        addn1 = (EditText)findViewById(R.id.addn1);
        addn2 = (EditText)findViewById(R.id.addn2);
        addEqual = (Button)findViewById(R.id.addEqual);
        addResult = (TextView)findViewById(R.id.addResult);

        // Event Listener for addEqual
        addEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        addEqualClicked(v);
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
                Intent formInt = new Intent(Add.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Add.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Add.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addEqualClicked(View view) {
        addResult.setText("");
        if (addn1.getText().toString().equals("") || addn2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = addn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = addn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            float n3;
            n3 = n1 + n2;
            addResult.setText("Result: " + n3);
        }

    }

}