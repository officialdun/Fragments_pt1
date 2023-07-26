package com.example.fragmentspt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragment_container);

        if (fragmentContainer!=null){
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            details.setWorkout(id);
            transaction.replace(R.id.fragment_container,details);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();



        }else {

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }

    }


}