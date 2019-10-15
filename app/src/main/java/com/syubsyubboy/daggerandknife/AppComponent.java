package com.syubsyubboy.daggerandknife;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    SharedPreferences getSharedPreferences();

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}
