package com.mi.hungry.simpleapp;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by Hungry on 11/9/2015.
 * Initialize fb sdk
 */
public class AppInit extends Application {
    @Override
    public void onCreate()
    {
     super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
