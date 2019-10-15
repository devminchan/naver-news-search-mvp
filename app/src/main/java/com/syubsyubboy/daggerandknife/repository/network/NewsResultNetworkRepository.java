package com.syubsyubboy.daggerandknife.repository.network;

import com.syubsyubboy.daggerandknife.entities.NewsResult;
import com.syubsyubboy.daggerandknife.repository.NewsResultRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class NewsResultNetworkRepository implements NewsResultRepository {

    private NaverSearchAPIService naverSearchAPIService;

    @Inject
    public NewsResultNetworkRepository(NaverSearchAPIService naverSearchAPIService) {
        this.naverSearchAPIService = naverSearchAPIService;
    }

    @Override
    public Flowable<List<NewsResult>> getArticles(String query) {
        return naverSearchAPIService
                .search(NaverAPIInfo.CLIENT_ID, NaverAPIInfo.CLIENT_SECRET, query, 100)
                .toFlowable()
                .map(SearchNewsResponse::getItems);
    }
}
