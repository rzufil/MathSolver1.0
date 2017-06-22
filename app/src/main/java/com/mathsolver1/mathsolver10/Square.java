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

public class Square extends AppCompatActivity {

    private static EditText squaren1;
    private static Button squareEqual;
    private static TextView squareResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square);

        squaren1 = (EditText)findViewById(R.id.squaren1);
        squareEqual = (Button)findViewById(R.id.squareEqual);
        squareResult = (TextView)findViewById(R.id.squareResult);

        // Event Listener for squareEqual
        squareEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        squareEqualClicked(v);
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
                Intent formInt = new Intent(Square.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Square.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Square.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void squareEqualClicked(View view) {
        squareResult.setText("");
        if (squaren1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = squaren1.getText().toString();
            float n1 = Float.valueOf(n1s);
            squareResult.setText("Area of the square: " + (n1 * n1));
        }

    }

}