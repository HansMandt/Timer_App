package com.example.timerapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.os.Looper.getMainLooper;

public class TimerFragment extends Fragment implements View.OnClickListener{


    private int seconds = 0;
    private int timerReset = 0;
    private TextView ft;
    private boolean paused = true;
    private FloatingActionButton fab;
    private Drawable PLAY;
    private Drawable PAUSE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setIcon() {
        Drawable icon = paused ? PAUSE : PLAY;
        fab.setImageDrawable(icon);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("paused", paused);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ft = view.findViewById(R.id.fragment_text);
        seconds = getArguments().getInt("Seconds");
        timerReset = seconds;
        fab = view.findViewById(R.id.play_pause_fab);
        fab.setOnClickListener(this);
        PLAY = getResources().getDrawable(android.R.drawable.ic_media_pause);
        PAUSE = getResources().getDrawable(android.R.drawable.ic_media_play);
        if (savedInstanceState != null) {
            paused = savedInstanceState.getBoolean("paused");
            seconds = savedInstanceState.getInt("seconds");
            setIcon();
        }
        runTimer();
    }

    public static TimerFragment newInstance(int Seconds) {
        TimerFragment tf = new TimerFragment();
        Bundle args = new Bundle();
        args.putInt("Seconds", Seconds);
        tf.setArguments(args);
        return tf;
    }

    public void startTimer() {
        paused = !paused;
        setIcon();
    }

    public void runTimer() {
        final Handler handler = new Handler(getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                int sec = seconds % 60;
                int min = (seconds % 3600) / 60;
                int hour = seconds / 3600;
                ft.setText(String.format("%02d : %02d : %02d", hour, min, sec));
                if (!paused) {
                    seconds--;
                }
                handler.postDelayed(this, 1000);
                if (seconds <= -1) {
                    seconds = timerReset;
                    startTimer();
                    sec = timerReset % 60;
                    min = (timerReset % 3600) / 60;
                    hour = timerReset / 3600;
                    ft.setText(String.format("%02d : %02d : %02d", hour, min, sec));
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_pause_fab:
                setIcon();
                startTimer();
                break;
        }
    }
}