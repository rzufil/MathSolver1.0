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

public class Rect extends AppCompatActivity {

    private static EditText rectanglen1;
    private static EditText rectanglen2;
    private static Button rectangleEqual;
    private static TextView rectangleResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangle);

        rectanglen1 = (EditText)findViewById(R.id.rectanglen1);
        rectanglen2 = (EditText)findViewById(R.id.rectanglen2);
        rectangleEqual = (Button)findViewById(R.id.rectangleEqual);
        rectangleResult = (TextView)findViewById(R.id.rectangleResult);

        // Event Listener for rectangleEqual
        rectangleEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        rectangleEqualClicked(v);
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
                Intent formInt = new Intent(Rect.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Rect.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Rect.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void rectangleEqualClicked(View view) {
        rectangleResult.setText("");
        if (rectanglen1.getText().toString().equals("") || rectanglen2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = rectanglen1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = rectanglen2.getText().toString();
            float n2 = Float.valueOf(n2s);
            rectangleResult.setText("Area of the rectangle: " + (n1 * n2));
        }

    }

}