package com.hackathon.workoutlogger.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @Expose
    @SerializedName(value = "name")
    private String mName;

    @Expose
    @SerializedName(value = "password")
    private String mPassword;

    public User(String name, String password) {
        mName = name;
        mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public String getPassword() {
        return mPassword;
    }

}
