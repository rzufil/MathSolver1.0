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

public class Sub extends AppCompatActivity {

    private static EditText subn1;
    private static EditText subn2;
    private static Button subEqual;
    private static TextView subResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        subn1 = (EditText)findViewById(R.id.subn1);
        subn2 = (EditText)findViewById(R.id.subn2);
        subEqual = (Button)findViewById(R.id.subEqual);
        subResult = (TextView)findViewById(R.id.subResult);

        // Event Listener for subEqual
        subEqual.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        subEqualClicked(v);
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
                Intent formInt = new Intent(Sub.this, Formulas.class);
                startActivity(formInt);
                return true;
            case R.id.about:
                Intent aboutInt = new Intent(Sub.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Sub.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void subEqualClicked(View view) {
        subResult.setText("");
        if (subn1.getText().toString().equals("") || subn2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "You forgot to choose a number!", Toast.LENGTH_LONG).show();
        }
        else {
            String n1s = subn1.getText().toString();
            float n1 = Float.valueOf(n1s);
            String n2s = subn2.getText().toString();
            float n2 = Float.valueOf(n2s);
            float n3;
            n3 = n1 - n2;
            subResult.setText("Result: " + n3);
        }

    }

}