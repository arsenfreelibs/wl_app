package com.hackathon.workoutlogger.models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

//    {"id":1,"email":"john111@mailinator.com","admin":false,"locked":false,"created_at":"2014-11-01T18:13:08.661Z","updated_at":"2014-11-01T18:13:08.661Z","first_name":"John","last_name":"Doe","access_token":"KZk_-fAvc1BCBZwSmms6"}

    @Expose
    @SerializedName(value = "email")
    private String mEmail;

    @Expose
    @SerializedName(value = "access_token")
    private String mAccessToken;



    private String mPassword;

    public User(String email, String password) {
        mEmail = email;
        mPassword = password;
        mAccessToken = "";
    }

    public String getName() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getAccessToken() {
        return mAccessToken;
    }
}
