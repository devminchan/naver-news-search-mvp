package com.syubsyubboy.daggerandknife.contracts;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class MainActivityPresenterImpl extends MainActivityContract.Presenter {

    SharedPreferences sharedPreferences;

    @Inject
    public MainActivityPresenterImpl(MainActivityContract.View view, SharedPreferences pref) {
        super(view);
        this.sharedPreferences = pref;
    }

    @Override
    public void initData() {
        this.view.onDataChanged(sharedPreferences.getString("data", ""));
    }

    @Override
    public void setData(String data) {
        sharedPreferences.edit().putString("data", data).apply();
        this.view.onDataChanged(data);
    }

}
