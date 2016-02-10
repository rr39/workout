package com.ravi.workout;

import android.app.Activity;
import android.os.Bundle;


public class WorkoutDetailActivity extends Activity {

    public static final String WORKOUT_ID = "workout_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);

        // get the fragment
        WorkoutDetailFragment fragment = (WorkoutDetailFragment)getFragmentManager().findFragmentById(R.id.detail_fragment);

        // get the workout id
        int workout_id = (int)getIntent().getExtras().get(WORKOUT_ID);

        // set the workout id to workout detail fragment
        fragment.setWorkoutId(workout_id);
    }


}
