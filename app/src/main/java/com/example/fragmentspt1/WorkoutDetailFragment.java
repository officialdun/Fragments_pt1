package com.example.fragmentspt1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {
    private long workoutID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState !=null){
            workoutID = savedInstanceState.getLong("id");

        }

        View view =  inflater.inflate(R.layout.fragment_workout_detail, container, false);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if(view!=null){
            TextView title = view.findViewById(R.id.title);
            Workout workout = Workout.workouts[(int) workoutID];
            title.setText(workout.getName());
            TextView description = view.findViewById(R.id.description);
            description.setText(workout.getDescription());
        }
    }


    public void setWorkout(long id){
        this.workoutID = id;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("id",workoutID);
    }
}