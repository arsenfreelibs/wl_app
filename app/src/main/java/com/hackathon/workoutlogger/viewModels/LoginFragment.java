package com.hackathon.workoutlogger.viewModels;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.hackathon.workoutlogger.MainActivity;
import com.hackathon.workoutlogger.R;
import com.hackathon.workoutlogger.models.user.User;

public class LoginFragment extends Fragment {

//    private UserProvider mUserProvider;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.login_fragment, null);
        view.findViewById(R.id.btnLoginMain).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        User user = getUserFromView(view);
                        progressDialog.show();
                        tryToLoginOnServer(user);
                    }
                });
        createProgressDialog();
        return view;
    }

    private User getUserFromView(View view) {
        String userLogin = ((EditText) view.findViewById(R.id.etLoginUserName))
                .getText().toString();
        String userPassword = ((EditText) view
                .findViewById(R.id.etLoginPassword)).getText().toString();
        User user = new User(userLogin, userPassword);

        return user;
    }

    private void tryToLoginOnServer(User user) {
//        mUserProvider.UserLogin(user, new UserLoginListener() {
//            @Override
//            public void UserLoginResult(boolean result) {
//                progressDialog.dismiss();
//                if (result) {
//                    SwitchToMediaListFragment();
//                } else {
//                    sendIncorrectUserOrPassw();
//                }
//            }
//        });
    }

    private void createProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Wait for login");
        progressDialog.setCancelable(false);
    }

    private void SwitchToMediaListFragment() {
        MainActivity mainActivity = (MainActivity) getActivity();
//        mainActivity.setMediaFragment();
    }

    private void sendIncorrectUserOrPassw() {
        Toast toast = Toast.makeText(getActivity(), "Incorrect user name ore password", Toast.LENGTH_LONG);
        toast.show();
    }
//
//    public UserProvider getUserProvider() {
//        return mUserProvider;
//    }
//
//    public void setUserProvider(UserProvider mUserProvider) {
//        this.mUserProvider = mUserProvider;
//    }
}
