package com.syubsyubboy.daggerandknife.modules;

import android.app.Activity;

import com.syubsyubboy.daggerandknife.components.MainComponent;
import com.syubsyubboy.daggerandknife.presentation.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainComponent.class)
public abstract class ActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainComponent.Builder builder);
}
