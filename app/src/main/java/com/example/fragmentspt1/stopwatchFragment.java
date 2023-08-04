package com.example.fragmentspt1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class stopwatchFragment extends Fragment implements View.OnClickListener {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    Button reset, Start,Stop;

 View layout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (savedInstanceState!=null){
            seconds = savedInstanceState.getInt("seconds");
            running =  savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }



         layout =   inflater.inflate(R.layout.fragment_stopwatch, container, false);


        if (layout!=null){
            Start = layout.findViewById(R.id.startBtn);
            Start.setOnClickListener(this);
            reset = layout.findViewById(R.id.resetBtn);
            reset.setOnClickListener(this);
            Stop = layout.findViewById(R.id.stopBtn);
            Stop.setOnClickListener(this);




        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = true;
            }
        });

        }

      runTimer(layout);

        return layout;
    }


   void runTimer(View view){
        final TextView timeView = view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);

    }});}

    @Override
    public void onResume(){
        super.onResume();


        Toast.makeText(getContext(), String.valueOf(wasRunning), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;

    }

    public void onClickStop(View layout){
        Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning",wasRunning);



    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.startBtn:
                    onClickStart();
                     break;

                case R.id.stopBtn:
                    onClickStop();
                    break;
                case R.id.resetBtn:
                    onClickReset();
                    break;

            }

    }



    private void onClickStart(){


    }
    private void onClickStop(){
        running = false;

    }
    private void onClickReset(){
        running = false;
        seconds = 0;
    }
}