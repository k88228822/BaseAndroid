package com.hello.baseproject.application;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by wangzhen on 2016/12/20.
 */

public class MyApplication extends Application {
    public static Context mAppContext;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext=this;
        application=this;
        Fresco.initialize(this);
    }

    public static Context getContext()
    {
        return mAppContext;
    }

    public static MyApplication getApplication(){return application;};
}
