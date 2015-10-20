package com.jiandanlicai.yzhlibrary;

import android.app.Application;

/**
 * Created by max on 15/10/16.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance;

    public static boolean sIsLogin = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}
