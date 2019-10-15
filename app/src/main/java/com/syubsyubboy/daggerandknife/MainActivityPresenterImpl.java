package com.syubsyubboy.daggerandknife;

import javax.inject.Inject;

public class MainActivityPresenterImpl extends MainActivityContract.Presenter {

    @Inject
    public MainActivityPresenterImpl(MainActivityContract.View v) {
        super(v);
    }

    @Override
    public void initData() {
        this.view.setItemData("hello");
    }
}
