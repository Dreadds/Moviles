package com.dreads.testcatchup;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Dreads on 25/09/2017.
 */

public class TestCatchUpApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
