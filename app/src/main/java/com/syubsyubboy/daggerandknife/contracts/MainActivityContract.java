package com.syubsyubboy.daggerandknife.contracts;

import android.support.annotation.NonNull;

import com.syubsyubboy.daggerandknife.entities.NewsResult;
import com.syubsyubboy.daggerandknife.repository.NewsResultRepository;

import java.util.List;

public interface MainActivityContract {
    abstract class Presenter {

        protected View view;
        protected NewsResultRepository repository;

        public Presenter(View view) {
            this.view = view;
        }

        public abstract void searchNews(String query);
    }

    interface View {
        void onNewsResultUpdated(List<NewsResult> results);
    }
}
