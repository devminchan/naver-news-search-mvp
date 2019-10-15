package com.syubsyubboy.daggerandknife.di.components;

import com.syubsyubboy.daggerandknife.di.modules.ActivityModule;
import com.syubsyubboy.daggerandknife.MyApp;
import com.syubsyubboy.daggerandknife.di.modules.ApplicationModule;
import com.syubsyubboy.daggerandknife.di.modules.MyAppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {ActivityModule.class, AndroidInjectionModule.class, MyAppModule.class, ApplicationModule.class})
public interface AppComponent {
    void inject(MyApp app);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(MyApp app);
    }
}
