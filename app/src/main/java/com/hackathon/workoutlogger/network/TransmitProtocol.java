package com.hackathon.workoutlogger.network;

public interface TransmitProtocol {

    public static final String USER_LOGIN_COMMAND = "USER_LOGIN";


    public void transmit(TransitionListener transitionListener, String... params);
}
