package com.thl.mvp.demo.net;

import com.thl.mvp.net.XApi;

/**
 * Created on 2016/12/31.
 */

public class Api {
    public static final String API_BASE_URL = "http://gank.io/api/";

    private static GankService gankService;

    public static GankService getGankService() {
        if (gankService == null) {
            synchronized (Api.class) {
                if (gankService == null) {
                    gankService = XApi.getInstance().getRetrofit(API_BASE_URL, true).create(GankService.class);
                }
            }
        }
        return gankService;
    }
}
