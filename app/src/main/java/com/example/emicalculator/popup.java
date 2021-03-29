package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;

public class popup extends AppCompatActivity {
    TextView printEMI;
    TextView printAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        getSupportActionBar().hide();

        printEMI=(TextView) findViewById(R.id.print);
        printAmount=(TextView)findViewById(R.id.printAmount);
        Intent intent =getIntent();
        String emi =intent.getStringExtra("emi");
        String amount=intent.getStringExtra("amount");

        printEMI.setText(emi);
        printAmount.setText(amount);

        }
 }
