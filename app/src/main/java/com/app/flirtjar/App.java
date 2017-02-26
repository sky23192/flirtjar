package com.app.flirtjar;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import apimodels.User;
import utils.TypeFaceUtil;

/**
 * Created by rutvik on 1/22/2017 at 7:25 PM.
 */

public class App extends Application
{
    public static final String APP_TAG = "FTJ ";

    private static App instance;

    private User user;

    public static App getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        TypeFaceUtil.setDefaultFont(this, "DEFAULT", "Pacifico-Regular.ttf");
        TypeFaceUtil.setDefaultFont(this, "MONOSPACE", "Montserrat-Regular.ttf");
        //TypeFaceUtil.setDefaultFont(this, "SERIF", "montserrat_bold.ttf");
        //TypeFaceUtil.setDefaultFont(this, "SANS_SERIF", "montserrat_bold.ttf");

        try
        {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.app.flirtjar",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures)
            {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e)
        {

        } catch (NoSuchAlgorithmException e)
        {

        }

    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
