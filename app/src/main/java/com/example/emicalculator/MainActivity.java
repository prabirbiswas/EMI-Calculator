package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText principal;
    public EditText interest;
    public EditText tenure;
    Button cal;
    Button reset;
    RadioGroup g;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        principal = (EditText) findViewById(R.id.principalText);
        interest = (EditText) findViewById(R.id.interestText);
        tenure = (EditText) findViewById(R.id.tenureText);
        cal = (Button) findViewById(R.id.calculateButton);
        reset = (Button) findViewById(R.id.resetButton);
        g=(RadioGroup)findViewById(R.id.tenRadio);

        principal.addTextChangedListener(input);
        interest.addTextChangedListener(input);
        tenure.addTextChangedListener(input);



        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double princ=Double.parseDouble(principal.getText().toString());
                double rate=Double.parseDouble(interest.getText().toString());
                int time=Integer.parseInt(tenure.getText().toString());

                switch (g.getCheckedRadioButtonId()){
                    case R.id.yrRadio:
                        time=time*12;
                        break;

                    case R.id.monRadio:
                        break;
                }
                Double ratInt=rate;
                rate=rate/(12*100);

                //calculation for EMI
                double emi= (princ * rate * (float)Math.pow(1+rate,time))/(float)(Math.pow(1+rate,time)-1);
                double amount=emi*time;
                Intent intent = new Intent(getApplicationContext(),popup.class);
                intent.putExtra("principal",princ);
                intent.putExtra("rate",ratInt);
                intent.putExtra("time",time);
                intent.putExtra("emi",emi);
                intent.putExtra("amount",amount);
                startActivity(intent);
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
        private TextWatcher input=new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String prin=principal.getText().toString().trim();
                        String ra=interest.getText().toString().trim();
                        String ten=tenure.getText().toString().trim();
                        cal.setEnabled(!prin.isEmpty() && !ra.isEmpty() && !ten.isEmpty());

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                };


}
