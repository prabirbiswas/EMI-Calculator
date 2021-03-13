package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText principal;
    EditText interest;
    EditText tenure;
    Button cal;
    Button reset;
    TextView print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        principal=(EditText) findViewById(R.id.principalText);
        interest=(EditText) findViewById(R.id.interestText);
        tenure=(EditText) findViewById(R.id.tenureText);
        cal=(Button)findViewById(R.id.calculateButton);
        reset=(Button) findViewById(R.id.resetButton);
        print=(TextView) findViewById(R.id.print);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double princ=Double.parseDouble(principal.getText().toString());
                double rate=Double.parseDouble(interest.getText().toString());
                double time=Double.parseDouble(tenure.getText().toString());

                rate=rate/(12*100);//interest calculation
                time=time*12;//year to month

                //calculation for EMI
                double emi= (princ * rate * (float)Math.pow(1+rate,time))/(float)(Math.pow(1+rate,time)-1);
                print.setText(Double.toString(emi));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principal.setText("");
                interest.setText("");
                tenure.setText("");
            }
        });
    }
}