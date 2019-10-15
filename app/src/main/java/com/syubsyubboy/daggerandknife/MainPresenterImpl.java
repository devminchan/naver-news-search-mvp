package com.syubsyubboy.daggerandknife;

public class MainPresenterImpl extends MainPresenter {

    public MainPresenterImpl(View v) {
        super(v);
    }

    @Override
    public void initData() {
        this.view.setItemData("hello");
    }
}
