package com.giftedcat.downloaddemo.application;

import android.app.Application;

import com.android.volley.MainUtils.FileUtils;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FileUtils.initFiles(this, "downLoadDemo");

    }
}

