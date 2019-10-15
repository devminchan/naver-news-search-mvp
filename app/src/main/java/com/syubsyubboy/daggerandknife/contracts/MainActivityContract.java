package com.syubsyubboy.daggerandknife.contracts;

import android.support.annotation.NonNull;

public interface MainActivityContract {
    abstract class Presenter {

        protected View view;

        public Presenter(View view) {
            setView(view);
        }

        public void setView(@NonNull View view) {
            this.view = view;
        }

        public abstract void initData();

        public abstract void setData(String data);
    }

    interface View {
        void onDataChanged(String data);
    }
}
