package com.syubsyubboy.daggerandknife.di.components;

import com.syubsyubboy.daggerandknife.di.modules.MainModule;
import com.syubsyubboy.daggerandknife.presentation.MainActivity;
import com.syubsyubboy.daggerandknife.di.scope.ActivityScoped;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScoped
@Subcomponent(modules = MainModule.class)
public interface MainComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
