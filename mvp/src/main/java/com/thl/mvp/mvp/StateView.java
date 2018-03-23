package com.thl.mvp.mvp;

/**
 * Created by Administrator on 2018/3/23.
 */

public abstract interface StateView<P> extends IView<P> {
    public abstract void showLoading();

    public abstract void showError();

    public abstract void showNetError();

    public abstract void showContent();

    public abstract void showEmpty();
}
