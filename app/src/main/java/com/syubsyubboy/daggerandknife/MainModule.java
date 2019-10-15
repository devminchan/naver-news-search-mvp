package com.syubsyubboy.daggerandknife;

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
