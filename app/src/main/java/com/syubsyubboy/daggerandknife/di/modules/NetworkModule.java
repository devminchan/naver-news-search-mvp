package com.syubsyubboy.daggerandknife.di.modules;

import com.syubsyubboy.daggerandknife.repository.network.NaverAPIInfo;
import com.syubsyubboy.daggerandknife.repository.network.NaverSearchAPIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NaverAPIInfo.API_URL)
                .build();
    }

    @Singleton
    @Provides
    public NaverSearchAPIService provideNaverSearchAPIService(Retrofit retrofit) {
        return retrofit.create(NaverSearchAPIService.class);
    }
}
