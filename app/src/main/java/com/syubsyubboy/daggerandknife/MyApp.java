package com.syubsyubboy.daggerandknife;

import android.app.Application;

public class MyApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().application(this).build();
    }

    public AppComponent getComponents() {
        return mAppComponent;
    }
}
