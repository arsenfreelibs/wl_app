package com.hackathon.workoutlogger.controllers.user;

import com.hackathon.workoutlogger.models.user.User;
import com.hackathon.workoutlogger.network.LoginCommandListener;
import com.hackathon.workoutlogger.network.TransitionManager;
import com.hackathon.workoutlogger.network.TransmitProtocol;

/**
 * Created by AAR on 11/1/14.
 */
public class UserControllerImpl implements UserController, LoginCommandListener {

    private UserLoginListener mUserLoginListener;
    private TransitionManager mTransitionManager;

    @Override
    public void UserLogin(User user, UserLoginListener userListener) {
        mUserLoginListener = userListener;
        mTransitionManager.SendLoginCommand(user, this);

//        mUserLoginListener.UserLoginResult(false);
    }

    @Override
    public boolean isUserLogged() {
        return false;
    }


    public void setTransitionManager(TransitionManager transitionManager) {
        this.mTransitionManager = transitionManager;
    }

    @Override
    public void LoginCommandResult(boolean result) {
        mUserLoginListener.UserLoginResult(result);
    }
}
