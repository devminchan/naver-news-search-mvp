package com.syubsyubboy.daggerandknife.di.modules;

import android.content.Context;

import com.syubsyubboy.daggerandknife.contracts.MainActivityContract;
import com.syubsyubboy.daggerandknife.contracts.MainActivityPresenterImpl;
import com.syubsyubboy.daggerandknife.presentation.MainActivity;
import com.syubsyubboy.daggerandknife.di.scope.ActivityScoped;
import com.syubsyubboy.daggerandknife.presentation.adapters.SearchResultAdapter;
import com.syubsyubboy.daggerandknife.repository.NewsResultRepository;
import com.syubsyubboy.daggerandknife.repository.network.NewsResultNetworkRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {
    @ActivityScoped
    @Binds
    abstract Context bindContext(MainActivity activity);

    @ActivityScoped
    @Binds
    abstract MainActivityContract.View bindView(MainActivity activity);

    @ActivityScoped
    @Binds
    abstract MainActivityContract.Presenter bindPresenter(MainActivityPresenterImpl mainActivityPresenter);

    @ActivityScoped
    @Binds
    abstract NewsResultRepository bindRepo(NewsResultNetworkRepository resultNetworkRepository);
}