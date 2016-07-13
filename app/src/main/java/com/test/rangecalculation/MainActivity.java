package com.test.rangecalculation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText5;
    TextView textView3;
    Button button;
    Double sizem, sizemi, Range;

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText5 = (EditText) findViewById(R.id.editText5);
        textView3 = (TextView) findViewById(R.id.textView3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sizem = Double.parseDouble(editText.getText().toString());
                    sizemi = Double.parseDouble(editText2.getText().toString());
                    Double wind = Double.parseDouble(editText3.getText().toString());

                } catch (NumberFormatException e) {
                    Double Range = sizem * 27.77 / sizemi;
                    Range = 1.0;
                }

                Double wind = Double.parseDouble(editText3.getText().toString());
                Double correction = Double.parseDouble(editText5.getText().toString());
                Range = sizem * 27.77 / sizemi;
                Range = round(Range, 2);
                Double MOAWind = Range / 100 * wind / 15;
                MOAWind = round(MOAWind, 2);
                Double drop = Range / 100;
                drop = round(drop, 2);
                Double RCWind = correction / drop;
                RCWind = round(RCWind, 2);
                textView3 = (TextView) findViewById(R.id.textView3);
                textView3.setText("Range: "+ Range +" yards. windage MOA: " + MOAWind + ". Adjust recticle " + RCWind + " MOA with "+ drop +" Inches per MOA.");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }
}



