package com.syubsyubboy.daggerandknife.contracts;

import android.util.Log;

import com.syubsyubboy.daggerandknife.repository.NewsResultRepository;

import javax.inject.Inject;

public class MainActivityPresenterImpl extends MainActivityContract.Presenter {

    private final String TAG = "MainActivityPresenter";

    @Inject
    public MainActivityPresenterImpl(MainActivityContract.View view, NewsResultRepository repository) {
        super(view, repository);
    }

    @Override
    public void searchNews(String query) {
        addDisposable(repository.getNews(query)
                .subscribe(this.view::onNewsResultUpdated,
                        throwable -> {
                            Log.e(TAG, throwable.toString());
                        }, () -> {
                            Log.d(TAG, "Complete search news task");
                        }));
    }

}
