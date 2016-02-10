package com.ravi.workout;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {


    private long workoutId;

    private static final String WORKOUT_ID = "workout_id";

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    // This method will be called when the fragment's view gets created.
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            workoutId = savedInstanceState.getLong(WORKOUT_ID);
        }

        // Create nested transaction
        // List of steps-- create transaction, create new instance for fragment, add fragment to transaction,
        // add transaction to backstack, set transition, commit.
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        fragmentTransaction.replace(R.id.stopwatch_container, stopwatchFragment).addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();

        if(view != null){
            TextView textTitle = (TextView)view.findViewById(R.id.textTitle);
            textTitle.setText(Workout.workouts[(int)workoutId].getName());

            TextView textDescription = (TextView)view.findViewById(R.id.textDescription);
            textDescription.setText(Workout.workouts[(int)workoutId].getDescription());
        }
    }

    public void setWorkoutId(long id){
        this.workoutId = id;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong(WORKOUT_ID, workoutId);
    }
}
