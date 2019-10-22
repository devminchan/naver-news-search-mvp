package com.syubsyubboy.daggerandknife.repository.network;

import com.syubsyubboy.daggerandknife.entities.NewsResult;
import com.syubsyubboy.daggerandknife.repository.NewsResultRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsResultNetworkRepository implements NewsResultRepository {

    private NaverSearchAPIService naverSearchAPIService;

    @Inject
    public NewsResultNetworkRepository(NaverSearchAPIService naverSearchAPIService) {
        this.naverSearchAPIService = naverSearchAPIService;
    }

    @Override
    public Flowable<List<NewsResult>> getNews(String query) {
        return naverSearchAPIService
                .search(NaverAPIInfo.CLIENT_ID, NaverAPIInfo.CLIENT_SECRET, query, 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(SearchNewsResponse::getItems)
                .toFlowable()
                .flatMapIterable(items -> items)
                .map(item -> {
                    String result = item.getTitle()
                            .replace("&quot;", "")
                            .replace("<b>", "")
                            .replace("</b>", "");

                    item.setTitle(result);
                    return item;
                })
                .toList()
                .toFlowable();
    }
}
