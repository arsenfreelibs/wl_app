package com.hackathon.workoutlogger.network;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by AAR on 11/1/14.
 */
public interface Transmitter {
    public String makeHttpRequest(String url, List<NameValuePair> params,
                                  String header);
}
