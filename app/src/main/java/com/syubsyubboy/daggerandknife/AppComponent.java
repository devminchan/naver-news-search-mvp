package com.syubsyubboy.daggerandknife;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class})
public interface AppComponent {
    void inject(MyApp app);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(MyApp app);
    }
}
