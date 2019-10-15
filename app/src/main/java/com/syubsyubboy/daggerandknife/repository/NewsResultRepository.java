package com.syubsyubboy.daggerandknife.repository;

import com.syubsyubboy.daggerandknife.entities.NewsResult;

import java.util.List;

import io.reactivex.Flowable;

public interface NewsResultRepository {
    Flowable<List<NewsResult>> getArticles(String query);
}
