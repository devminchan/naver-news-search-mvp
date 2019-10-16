package com.syubsyubboy.daggerandknife.di.modules;

import com.syubsyubboy.daggerandknife.repository.network.NaverSearchAPIService;
import com.syubsyubboy.daggerandknife.repository.network.NewsResultNetworkRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    NewsResultNetworkRepository provideNewsResultNetworkRepository(NaverSearchAPIService searchAPIService) {
        return new NewsResultNetworkRepository(searchAPIService);
    }
}
