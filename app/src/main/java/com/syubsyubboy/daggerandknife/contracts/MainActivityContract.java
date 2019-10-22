package com.syubsyubboy.daggerandknife.contracts;

import android.support.annotation.NonNull;

import com.syubsyubboy.daggerandknife.entities.NewsResult;
import com.syubsyubboy.daggerandknife.repository.NewsResultRepository;

import java.util.List;

public interface MainActivityContract {
    abstract class Presenter extends BasePresenter<View> {

        protected NewsResultRepository repository;

        public Presenter(@NonNull View view, NewsResultRepository repository) {
            super(view);
            this.repository = repository;
        }

        public abstract void searchNews(String query);
    }

    interface View extends BaseView {
        void onNewsResultUpdated(List<NewsResult> results);
    }
}
