package com.syubsyubboy.daggerandknife.contracts;

import android.content.SharedPreferences;
import android.util.Log;

import com.syubsyubboy.daggerandknife.entities.NewsResult;
import com.syubsyubboy.daggerandknife.repository.NewsResultRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

public class MainActivityPresenterImpl extends MainActivityContract.Presenter {

    private final String TAG = "MainActivityPresenter";

    NewsResultRepository resultRepository;

    @Inject
    public MainActivityPresenterImpl(MainActivityContract.View view, NewsResultRepository repository) {
        super(view);
        this.resultRepository = repository;
    }

    @Override
    public void searchNews(String query) {
        resultRepository.getNews(query)
                .subscribe(view::onNewsResultUpdated,
                        throwable -> {
                            Log.e(TAG, throwable.toString());
                        }, () -> {
                            Log.d(TAG, "Complete search news task");
                        });
    }

}
