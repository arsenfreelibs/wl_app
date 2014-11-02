package com.hackathon.workoutlogger.viewModels;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hackathon.workoutlogger.R;
import com.hackathon.workoutlogger.models.exercises.Exercises;
import com.hackathon.workoutlogger.models.exercises.ExercisesOnlyTime;
import com.hackathon.workoutlogger.view.adapter.ExercisesAdapter;

/**
 * Created by AAR on 11/1/14.
 */
public class ExercisesFragment extends Fragment {

    private ListView mListView;
    private ExercisesAdapter mAdapter;

//    private MediaDataProvider mMediaDataProvider;

    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exercises_list_fragment, null, false);

        createProgressDialog();
        installListView(view);
        loadMediaDataFromNet();

        return view;
    }

    private void loadMediaDataFromNet() {
//        progressDialog.show();
//        mMediaDataProvider.LoadMediaFromNet(new MediaReceiveListener() {
//            @Override
//            public void mediaReceive(List<MediaData> medias) {
//                fillMediaList();
//                progressDialog.dismiss();
//            }
//
//        });

        //TODO: for debug
        fillMediaList();
    }

    private void installListView(View view) {
        mListView = (ListView) view.findViewById(R.id.lvExercises);
        mAdapter = new ExercisesAdapter(getActivity());

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {

//                ((MainActivity) getActivity()).switchToVideoFragment(mMediaDataProvider.getUriById(position));
            }
        });
    }

    private void fillMediaList() {
//        mAdapter.addAll(mMediaDataProvider.getTitles());

        //TODO: for debug
        mAdapter.add(new Exercises("ex item 1"));
        mAdapter.add(new ExercisesOnlyTime("ex item 2","123","13:00"));
        mAdapter.add(new Exercises("ex item 3"));
    }

    private void createProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Wait for load media data");
        progressDialog.setCancelable(false);
    }

//    public void setMediaDataProvider(MediaDataProvider mMediaDataProvider) {
//        this.mMediaDataProvider = mMediaDataProvider;
//    }

}