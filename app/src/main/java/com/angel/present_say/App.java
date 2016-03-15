package com.angel.present_say;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Angel on 2016/1/29.
 */
public class App extends Application {

    private static App app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
    public static App getInstance(){
        return  app;
    }
}
