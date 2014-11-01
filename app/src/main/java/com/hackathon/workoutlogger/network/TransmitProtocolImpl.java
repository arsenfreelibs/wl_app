package com.hackathon.workoutlogger.network;

/**
 * Created by AAR on 11/1/14.
 */
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


import android.os.AsyncTask;

public class TransmitProtocolImpl implements TransmitProtocol {

    private final String LOGIN_URL = "http://workout-wl.herokuapp.com/api/v1/sessions.json";

    private TransitionListener mTransitionListener;
    private Transmitter mTransmitter;


    public TransmitProtocolImpl(Transmitter transmitter) {
        mTransmitter = transmitter;
    }

    @Override
    public void transmit(TransitionListener transitionListener, String... params) {
        mTransitionListener = transitionListener;
        TransmitAsyncTask transmitTask = createAsyncTask();
        transmitTask.execute(params);
    }

    protected TransmitAsyncTask createAsyncTask() {
        return new TransmitAsyncTask();
    }

    protected String decodeTransmitCommand(String... params) {
        String result = "";
        if (params[0] == TransmitProtocol.USER_LOGIN_COMMAND) {
            result = transmitLogin(LOGIN_URL, params[1], params[2]);
        }
//        if (params[0] == TransmitProtocol.MEDIA_LIST_COMMAND) {
//            result = transmitMedia(MEDIA_URL, params[1]);
//        }
        return result;
    }

    protected String transmitMedia(String url, String token) {
        String json = "";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        json = mTransmitter.makeHttpRequest(url, params, token);

        return json.substring(0, json.length() - 1);
    }


    protected String transmitLogin(String url, String login, String password) {


        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user[email]", login));
        params.add(new BasicNameValuePair("user[password]", password));

        String json = mTransmitter.makeHttpRequest(url, params, "");

        return json;
//        return json.substring(0, json.length() - 1);
    }

    protected void returnResult(String jsonData) {
        mTransitionListener.setResult(jsonData);
    }

    private class TransmitAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String result) {
            returnResult(result);
            super.onPostExecute(result);
        }

        @Override
        protected String doInBackground(String... params) {
            String result = decodeTransmitCommand(params);
            return result;
        }
    }
}
