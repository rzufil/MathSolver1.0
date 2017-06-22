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

public class Pyramid extends AppCompatActivity {

    private static EditText pyramidn1;
    private static EditText pyramidn2;
    private static EditText pyramidn3;
    private static Button pyramidEqual;
    private static TextView pyramidResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pyramid);

        pyramidn1 = (EditText)findViewById(R.id.pyramidn1);
        pyramidn2 = (EditText)findViewById(R.id.pyramidn2);
        pyramidn3 = (EditText)findViewById(R.id.pyramidn3);
        pyramidEqual = (Button)findViewById(R.id.pyramidEqual);
        pyramidResult = (TextView)findViewById(R.id.pyramidResult);

        // Event Listener for pyramidEqual
        pyramidEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        pyramidEqualClicked(v);
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
                Intent formInt = new Intent(Pyramid.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Pyramid.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Pyramid.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void pyramidEqualClicked(View view) {
        pyramidResult.setText("");
        if (pyramidn1.getText().toString().equals("") || pyramidn2.getText().toString().equals("") || pyramidn3.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = pyramidn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = pyramidn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            String n3s = pyramidn3.getText().toString();
            float n3 = Float.valueOf(n3s);
            double n4;
            n4 = (n1 * n2 * n3) / 3;
            pyramidResult.setText("Volume of the pyramid: " + n4);

        }

    }

}