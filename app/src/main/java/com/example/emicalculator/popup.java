package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;

public class popup extends AppCompatActivity {
    TextView printEMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        getSupportActionBar().hide();

        printEMI=(TextView) findViewById(R.id.print);

        Intent intent =getIntent();
        String emi =intent.getStringExtra("emi");
        printEMI.setText(emi);

        }
 }
