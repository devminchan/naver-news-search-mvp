package com.syubsyubboy.daggerandknife;

import android.support.annotation.NonNull;

interface MainActivityContract {
    abstract class Presenter {

        protected View view;

        public Presenter(View view) {
            setView(view);
        }

        public void setView(@NonNull View view) {
            this.view = view;
        }

        public abstract void initData();

    }

    interface View {
        void setItemData(String data);
    }
}
