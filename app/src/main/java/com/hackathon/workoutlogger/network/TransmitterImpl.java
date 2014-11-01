package com.hackathon.workoutlogger.network;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by AAR on 11/1/14.
 */
public class TransmitterImpl implements Transmitter {
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    public TransmitterImpl() {

    }

    /**
     * Получить ответ по ссылке в формате json
     *
     * @param url    запрашиваемая страница
     * @param params параметры, которые необходимо передать
     * @return
     */
    @Override
    public String makeHttpRequest(String url, List<NameValuePair> params,
                                  String header) {

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            if (params.size() > 0) {
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
            }
            HttpPost httpGet = new HttpPost(url);
            if (header != "") {
                httpGet.addHeader("X-Auth-Token", header);
            }

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        return json;

    }

}
