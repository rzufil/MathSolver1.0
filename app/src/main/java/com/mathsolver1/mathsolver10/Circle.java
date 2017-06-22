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

public class Circle extends AppCompatActivity {

    private static EditText circlen1;
    private static Button circleEqual;
    private static TextView circleResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle);

        circlen1 = (EditText)findViewById(R.id.circlen1);
        circleEqual = (Button)findViewById(R.id.circleEqual);
        circleResult = (TextView)findViewById(R.id.circleResult);

        // Event Listener for circleEqual
        circleEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        circleEqualClicked(v);
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
                Intent formInt = new Intent(Circle.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Circle.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Circle.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void circleEqualClicked(View view) {
        circleResult.setText("");
        if (circlen1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = circlen1.getText().toString();
            float n1 = Float.valueOf(n1s);
            double n2;
            n2 = Math.PI * n1 * n1;
            circleResult.setText("Area of the circle: " + n2);
        }

    }

}