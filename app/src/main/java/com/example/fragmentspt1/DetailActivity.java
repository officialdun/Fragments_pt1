package com.example.fragmentspt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_WORKOUT_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //int id =(int) getIntent().getExtras().get("EXTRA_WORKOUT_ID");
        int id = 3;

        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
         frag.setWorkout(id);



    }
}