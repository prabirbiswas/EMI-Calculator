    package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

    public class intro extends AppCompatActivity {

    private final int DELAY=2500;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        getWindow().setBackgroundDrawable(null);

        InitializeView();
        animateLogo();
        goToMainActivity();

    }
    private void InitializeView(){
        imageView = findViewById(R.id.img);
    }

    private void animateLogo(){
        Animation fadingInAnimation= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadingInAnimation.setDuration(DELAY);
        imageView.startAnimation(fadingInAnimation);
    }

    private void goToMainActivity(){
        new Handler().postDelayed(()-> {
            startActivity(new Intent(intro.this, MainActivity.class));
            finish();
        }, DELAY);

    }

}