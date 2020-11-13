package com.example.timerapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimerFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        TextView ft = view.findViewById(R.id.fragment_text);
        int seconds = getArguments().getInt("Seconds");
        ft.setText("Seconds are: " + seconds);
    }

    public static TimerFragment newInstance(int Seconds) {
        TimerFragment tf = new TimerFragment();
        Bundle args = new Bundle();
        args.putInt("Seconds", Seconds);
        tf.setArguments(args);
        return tf;
    }
}