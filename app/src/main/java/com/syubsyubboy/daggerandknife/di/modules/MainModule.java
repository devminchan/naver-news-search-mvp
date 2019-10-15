package com.syubsyubboy.daggerandknife.di.modules;

import com.syubsyubboy.daggerandknife.contracts.MainActivityContract;
import com.syubsyubboy.daggerandknife.contracts.MainActivityPresenterImpl;
import com.syubsyubboy.daggerandknife.presentation.MainActivity;
import com.syubsyubboy.daggerandknife.di.scope.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {
    @ActivityScoped
    @Binds
    abstract MainActivityContract.View bindView(MainActivity activity);

    @ActivityScoped
    @Binds
    abstract MainActivityContract.Presenter bindPresenter(MainActivityPresenterImpl mainActivityPresenter);
}