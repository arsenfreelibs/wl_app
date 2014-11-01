package com.hackathon.workoutlogger.network;

import com.hackathon.workoutlogger.models.user.User;
import com.hackathon.workoutlogger.utils.Converter;

/**
 * Created by AAR on 11/1/14.
 */
public class TransitionManagerImpl implements TransitionManager {
    private TransmitProtocol mTransmitProtocol;
    private LoginCommandListener mLoginCommandListener;
//    private MediaCommandListener mMediaCommandListener;
    String mTokenAPI = "";

    private String mJson;

    public TransitionManagerImpl() {
//        mTokenAPI = new TokenAPI("");
    }

    public void setTransmitProtocol(TransmitProtocol mTransmitTask) {
        this.mTransmitProtocol = mTransmitTask;
    }

    public void SendLoginCommand(User user,
                                 LoginCommandListener loginCommandListener) {

        mLoginCommandListener = loginCommandListener;


        mTransmitProtocol.transmit(new TransitionListener() {
            public void setResult(String json) {
                setLoginResult(json);
            }
        }, TransmitProtocol.USER_LOGIN_COMMAND, user.getName(), user.getPassword());

    }
//
//    public void SendMediaCommand(MediaCommandListener mediaCommandListener) {
//        mMediaCommandListener = mediaCommandListener;
//
//        mTransmitProtocol.transmit(new TransmitionListener() {
//            public void setResult(String json) {
//                setMediaResult(json);
//            }
//        }, TransmitProtocol.MEDIA_LIST_COMMAND, mTokenAPI.getTokenAPI());
//
//    }

    public void setLoginResult(String json) {
        boolean result = false;
        if (mLoginCommandListener != null) {
            result = convertJsonToUser(json);
            mLoginCommandListener.LoginCommandResult(result);
        }

    }

//    public void setMediaResult(String json) {
//        List<MediaData> medias;
//
//        medias = getMediaFromPkg(json);
//
//        mMediaCommandListener.MediaCommandResult(medias);
//    }

    private boolean convertJsonToUser(String json) {
        try {
            User user = Converter.fromJSON(User.class, json);
            mTokenAPI = user.getAccessToken();
            return true;
        } catch (Exception InvocationTargetException) {
            return false;
        }
    }

//    private ArrayList<MediaData> getMediaFromPkg(String json) {
//        ArrayList<MediaData> medias;
//
//        PkgData pkg = createPkgFromJson(json);
//        if (pkg.getError() != 0) {
//            pkg.setPkgMediaWhenError();
//        }
//        medias = pkg.getMedias();
//
//        return medias;
//    }

//    private PkgData createPkgFromJson(String json) {
//        PkgData pkg = new PkgData();
//        try {
//            pkg = Converter.fromJSON(PkgData.class, json);
//
//        } catch (Exception InvocationTargetException) {
//            pkg.setPkgMediaWhenError();
//        }
//        return pkg;
//    }

    public String getJson() {
        return mJson;
    }

    public void setJson(String mJson) {
        this.mJson = mJson;
    }
}
