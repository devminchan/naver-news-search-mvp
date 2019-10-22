package com.syubsyubboy.daggerandknife.contracts;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends BaseView> {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    protected void addDisposable(Disposable d) {
        compositeDisposable.add(d);
    }

    public void dispose() {
        compositeDisposable.dispose();
    }
}
