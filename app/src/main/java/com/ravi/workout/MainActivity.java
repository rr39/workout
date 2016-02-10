package com.ravi.workout;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemClicked(long id){

        View fragmentManager = findViewById(R.id.container_fragment);
        if(fragmentManager!=null){
            WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
            workoutDetailFragment.setWorkoutId(id);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container_fragment, workoutDetailFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.addToBackStack(null);
            transaction.commit();
        } else{
            Intent intent = new Intent(this, WorkoutDetailActivity.class);
            intent.putExtra(WorkoutDetailActivity.WORKOUT_ID, id);
            startActivity(intent);
        }

    }

}
