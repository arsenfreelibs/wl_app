package com.hackathon.workoutlogger.controllers.user;


import com.hackathon.workoutlogger.models.user.User;

public interface  UserController {

    public void UserLogin(User user, UserLoginListener userListener);

    public boolean isUserLogged();
}
