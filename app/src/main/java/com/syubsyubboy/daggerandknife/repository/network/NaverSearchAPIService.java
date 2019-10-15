package com.syubsyubboy.daggerandknife.repository.network;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NaverSearchAPIService {
    @GET("search/news.json")
    Single<SearchNewsResponse> search(
            @Header("X-Naver-Client-Id") String clientId,
            @Header("X-Naver-Client-Secret") String secret,
            @Query("query") String query,
            @Query("display") int display
    );
}
