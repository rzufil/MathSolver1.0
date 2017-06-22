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

public class Triangle extends AppCompatActivity {

    private static EditText trianglen1;
    private static EditText trianglen2;
    private static Button triangleEqual;
    private static TextView triangleResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangle);

        trianglen1 = (EditText)findViewById(R.id.trianglen1);
        trianglen2 = (EditText)findViewById(R.id.trianglen2);
        triangleEqual = (Button)findViewById(R.id.triangleEqual);
        triangleResult = (TextView)findViewById(R.id.triangleResult);

        // Event Listener for triangleEqual
        triangleEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        triangleEqualClicked(v);
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
                Intent formInt = new Intent(Triangle.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Triangle.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Triangle.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void triangleEqualClicked(View view) {
        triangleResult.setText("");
        if (trianglen1.getText().toString().equals("") || trianglen2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = trianglen1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = trianglen2.getText().toString();
            float n2 = Float.valueOf(n2s);
            double n3;
            n3 = ((double)n1 * (double)n2)/2;
            triangleResult.setText("Area of the triangle: " + n3);
        }

    }

}