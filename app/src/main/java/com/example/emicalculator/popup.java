package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import android.graphics.Color;


public class popup extends AppCompatActivity {


    TextView ten,ttlamt,prinAmt,emi,rate;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        getSupportActionBar().hide();

        ttlamt = findViewById(R.id.ttlamt);
        prinAmt = findViewById(R.id.prinAmt);
        ten= findViewById(R.id.ten);
        rate = findViewById(R.id.inter);
       // pieChart = findViewById(R.id.piechart);
        emi=findViewById(R.id.emi);

        setData();
    }

    private void setData()
    {


        Intent intent =getIntent();
        Double emi1 =intent.getDoubleExtra("emi",0.00);
        Double amount=intent.getDoubleExtra("amount",0.00);
        int tenu=intent.getIntExtra("time",00);
        Double inter=intent.getDoubleExtra("rate",0.00);
        Double princi=intent.getDoubleExtra("principal",0.00);


        String e=String.format("%.2f",emi1);
        String a=String.format("%.2f",amount);
        String p=String.format("%.2f",princi);
        String i=String.format("%.2f",inter);

        emi.setText(e);
        ttlamt.setText(a);
        prinAmt.setText(p);
        ten.setText(tenu+" Months");
        rate.setText(i);



    }
}
