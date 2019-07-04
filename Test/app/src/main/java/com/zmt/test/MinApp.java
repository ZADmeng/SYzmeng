package com.zmt.test;

import android.app.Application;

import com.baidu.mobads.AdView;

public class MinApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AdView.setAppSid(this,  "bc4d63ba");
    }

}
