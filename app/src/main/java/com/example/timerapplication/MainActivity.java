package com.example.timerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.timer_1_btn)).setOnClickListener(this);

        ((Button)findViewById(R.id.timer_2_btn)).setOnClickListener(this);

        ((Button)findViewById(R.id.timer_3_btn)).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
        switch (view.getId()) {
            case R.id.timer_1_btn:
                intent.putExtra("Seconds", 30);
                startActivity(intent);
                break;
            case R.id.timer_2_btn:
                intent.putExtra("Seconds", 90);
                startActivity(intent);
                break;
            case R.id.timer_3_btn:
                intent.putExtra("Seconds", 4500);
                startActivity(intent);
                break;
        }

    }
}