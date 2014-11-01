package com.hackathon.workoutlogger.network;

import com.hackathon.workoutlogger.models.user.User;

/**
 * Created by AAR on 11/1/14.
 */
public interface TransitionManager {
    public void SendLoginCommand(User user,
                                 LoginCommandListener loginCommandListener);
}
