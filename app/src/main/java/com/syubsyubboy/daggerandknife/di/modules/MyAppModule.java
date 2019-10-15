package com.syubsyubboy.daggerandknife.di.modules;

import android.app.Application;

import com.syubsyubboy.daggerandknife.MyApp;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MyAppModule {

    @Singleton
    @Binds
    abstract Application getApplication(MyApp myApp);
}
