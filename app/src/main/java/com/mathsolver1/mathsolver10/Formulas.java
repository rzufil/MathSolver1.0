package com.mathsolver1.mathsolver10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Formulas extends AppCompatActivity {

    private static TextView areasFormulas;
    private static TextView temperaturesFormulas;
    private static TextView volumesFormulas;
    private static TextView lengthsFormulas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas);

        areasFormulas = (TextView)findViewById(R.id.areasFormulas);
        temperaturesFormulas = (TextView)findViewById(R.id.temperaturesFormulas);
        volumesFormulas = (TextView)findViewById(R.id.volumesFormulas);
        lengthsFormulas = (TextView)findViewById(R.id.lengthsFormulas);

        areasFormulas.setText("Square: Area = a²\n(a = edge)\n\n" +
                "Circle: Area = ϖ * r²\n(ϖ = pi; r = radius)\n\n" +
                "Triangle: Area = (h * b) / 2\n(h = height; b = base)\n\n" +
                "Rectangle: Area = w * l\n(w = width; l = length)\n\n" +
                "Trapezoid: Area = ((a + b) / 2) * h\n(a = smaller base; b = biggest base; h = height)");
        volumesFormulas.setText("Cube: Volume = a³\n(a = side)\n\n" +
                "Cylinder: Volume = ϖ * r² * h\n(ϖ = pi; r = radius; h = height)\n\n" +
                "Pyramid: Volume = (l * w * h) / 3\n(l = base length; w = base width; h = height)\n\n" +
                "Cone: Volume = ϖ * r² * (h / 3)\n(ϖ = pi; r = radius; h = height)\n\n" +
                "Sphere: Volume = (4 / 3) * ϖ * r³\n(r = radius)");
        temperaturesFormulas.setText("Celsius to Fahrenheit:\nT(℉) = T(℃) * (9 / 5) + 32\n\n" +
                "Fahrenheit to Celsius:\nT(℃) = ( T(℉) - 32) * (5 / 9)\n\n" +
                "Celsius to Kelvin:\nT(K) = T(℃) + 273.15\n\n" +
                "Kelvin to Celsius:\nT(℃) = T(K) - 273.15\n\n" +
                "Fahrenheit to Kelvin:\nT(K) = (T(℉) + 459.67) * (5 / 9)\n\n" +
                "Kelvin to Fahrenheit:\nT(℉) = T(K) * (9 / 5) - 459.67");
        lengthsFormulas.setText("Centimeter to Meter:\nm = cm / 100\n\n" +
                "Centimeter to Kilometer:\nkm = cm / 100,000\n\n" +
                "Centimeter to Inch:\nin = cm / 2.54\n\n" +
                "Centimeter to Foot:\nft = cm / 30.48\n\n" +
                "Centimeter to Yard:\nyd = cm / 91.44\n\n" +
                "Centimeter to Mile:\nmi = cm / 160,934.4\n\n" +
                "Meter to Kilometer:\nkm = m / 1,000\n\n" +
                "Meter to Inch:\nin = m / 0.0254\n\n" +
                "Meter to Foot:\nft = m / 0.3048\n\n" +
                "Meter to Yard:\nyd = m / 0.9144\n\n" +
                "Meter to Mile:\nmi = m / 1,609.344\n\n" +
                "Kilometer to Inch:\nin = km / 0.0000254\n\n" +
                "Kilometer to Foot:\nft = km / 0.0003048\n\n" +
                "Kilometer to Yard:\nyd = km / 0.0009144\n\n" +
                "Kilometer to Mile:\nmi = km / 1.609344\n\n" +
                "Inch to Foot:\nft = in / 12\n\n" +
                "Inch to Yard:\nyd = in / 36\n\n" +
                "Inch to Mile:\nmi = in / 63,360\n\n" +
                "Foot to Yard:\nyd = ft / 3\n\n" +
                "Foot to Mile:\nmi = ft / 5,280\n\n" +
                "Yard to Mile:\nmi = yd / 1,760");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent aboutInt = new Intent(Formulas.this, About.class);
                startActivity(aboutInt);
                return true;
            case R.id.contact:
                Intent contactInt = new Intent(Formulas.this, Contact.class);
                startActivity(contactInt);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}