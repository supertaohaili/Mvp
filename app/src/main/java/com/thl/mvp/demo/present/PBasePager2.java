package com.thl.mvp.demo.present;

import com.thl.mvp.demo.model.GankResults;
import com.thl.mvp.demo.net.Api;
import com.thl.mvp.demo.ui.BasePagerFragment;
import com.thl.mvp.demo.ui.HomeFragment2;
import com.thl.mvp.mvp.XPresent;
import com.thl.mvp.net.ApiSubscriber;
import com.thl.mvp.net.NetError;
import com.thl.mvp.net.XApi;

/**
 * Created on 2016/12/31.
 */

public class PBasePager2 extends XPresent<HomeFragment2> {
    protected static final int PAGE_SIZE = 10;


    public void loadData(String type, final int page) {
        Api.getGankService().getGankData(type, PAGE_SIZE, page)
                .compose(XApi.<GankResults>getApiTransformer())
                .compose(XApi.<GankResults>getScheduler())
                .compose(getV().<GankResults>bindToLifecycle())
                .subscribe(new ApiSubscriber<GankResults>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }

                    @Override
                    public void onNext(GankResults gankResults) {
                        getV().showData(page, gankResults);
                    }
                });
    }
}
