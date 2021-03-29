package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

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

        principal = (EditText) findViewById(R.id.principalText);
        interest = (EditText) findViewById(R.id.interestText);
        tenure = (EditText) findViewById(R.id.tenureText);
        cal = (Button) findViewById(R.id.calculateButton);
        reset = (Button) findViewById(R.id.resetButton);
        print = (TextView) findViewById(R.id.print);
        RadioGroup g=(RadioGroup)findViewById(R.id.tenRadio);


        principal.addTextChangedListener(input);
        interest.addTextChangedListener(input);
        tenure.addTextChangedListener(input);



        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double princ=Double.parseDouble(principal.getText().toString());
                double rate=Double.parseDouble(interest.getText().toString());
                double time=Double.parseDouble(tenure.getText().toString());

                rate=rate/(12*100);//interest calculation


                switch (g.getCheckedRadioButtonId()){
                    case R.id.yearButton:
                        time=time*12;
                        break;

                    case R.id.monthButton:
                        time=time/12;
                        break;
                }


                //calculation for EMI
                double emi= (princ * rate * (float)Math.pow(1+rate,time))/(float)(Math.pow(1+rate,time)-1);
                double amount=emi*time;

                String s= Double.toString(emi);
                String s1=Double.toString(amount);


                Intent intent = new Intent(getApplicationContext(),popup.class);
                intent.putExtra("principal",princ);
                intent.putExtra("rate",rate);
                intent.putExtra("time",time);
                intent.putExtra("emi",s);
                intent.putExtra("amount",s1);
                startActivity(intent);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principal.setText("");
                interest.setText("");
                tenure.setText("");
                print.setText("");

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
