package com.syubsyubboy.daggerandknife;

import android.support.annotation.NonNull;

public abstract class MainPresenter {

    protected View view;

    public MainPresenter(View view) {
        setView(view);
    }

    public void setView(@NonNull View v) {
        this.view = v;
    }

    public abstract void initData();

    public interface View {
        void setItemData(String data);
    }
}
