package com.hackathon.workoutlogger;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.workoutlogger.controllers.user.UserController;
import com.hackathon.workoutlogger.controllers.user.UserControllerImpl;
import com.hackathon.workoutlogger.network.TransitionManager;
import com.hackathon.workoutlogger.network.TransitionManagerImpl;
import com.hackathon.workoutlogger.network.TransmitProtocolImpl;
import com.hackathon.workoutlogger.network.TransmitterImpl;
import com.hackathon.workoutlogger.viewModels.LoginFragment;
import com.hackathon.workoutlogger.viewModels.PlaceListFragment;
import com.hackathon.workoutlogger.viewModels.WorkoutFragment;


public class MainActivity extends Activity {

    private LoginFragment mLoginFragment;
    private FragmentTransaction mFragmentTrans;
    private UserControllerImpl mUserController;
    private TransitionManagerImpl mTransitionManager;
    private PlaceListFragment mPlaceListFragment;
    private WorkoutFragment mWorkoutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        createApp();

        setLoginFragment();
    }

    private void setLoginFragment() {
        mFragmentTrans = getFragmentManager().beginTransaction();
        mFragmentTrans.add(R.id.container, mLoginFragment);
        mFragmentTrans.commit();
    }

    public void switchToPlaceFragment() {
        switchToFragment(mPlaceListFragment);
    }

    public void switchToWorkoutFragment() {
        switchToFragment(mWorkoutFragment);
    }

    private void switchToFragment(Fragment fragment) {
        mFragmentTrans = getFragmentManager().beginTransaction();
        mFragmentTrans.replace(R.id.container, fragment);
        mFragmentTrans.addToBackStack(null);
        mFragmentTrans.commit();
    }

    private void createApp() {

        mTransitionManager = new TransitionManagerImpl();
        mTransitionManager.setTransmitProtocol(new TransmitProtocolImpl(new TransmitterImpl()));

        mUserController = new UserControllerImpl();
        mUserController.setTransitionManager(mTransitionManager);

        mLoginFragment = new LoginFragment();
        mLoginFragment.setUserController(mUserController);

        mPlaceListFragment = new PlaceListFragment();

        mWorkoutFragment = new WorkoutFragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
