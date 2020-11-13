package com.example.timerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer1);

        int seconds = getIntent().getExtras().getInt("Seconds");

        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.fragment_container, TimerFragment.newInstance(seconds))
            .commit();
    }
}