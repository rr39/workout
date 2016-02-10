package com.ravi.workout;


import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {


    static interface WorkoutListListener{
        void onItemClicked(long id);
    }

    WorkoutListListener workoutListListener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] names = new String[Workout.workouts.length];

        for( int i=0; i< Workout.workouts.length; i++ ){
            names[i] = Workout.workouts[i].getName();
        }

        // Create an Array Adapter to bind the data in array to the list view.
        ArrayAdapter<String> workoutListAdapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, names);

        // bind the adapter to the view
        setListAdapter(workoutListAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.workoutListListener = (WorkoutListListener)activity;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id){
        if(workoutListListener != null){
            workoutListListener.onItemClicked(id);
        }
    }


}
