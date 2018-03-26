package com.thl.mvp.demo;

import android.app.Application;
import android.content.Context;

import com.thl.mvp.MvpApplication;
import com.thl.mvp.net.NetError;
import com.thl.mvp.net.NetProvider;
import com.thl.mvp.net.RequestHandler;
import com.thl.mvp.net.XApi;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created on 2016/12/31.
 */

public class App extends MvpApplication {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        XApi.registerProvider(new NetProvider() {

            @Override
            public Interceptor[] configInterceptors() {
                return new Interceptor[0];
            }

            @Override
            public void configHttps(OkHttpClient.Builder builder) {

            }

            @Override
            public CookieJar configCookie() {
                return null;
            }

            @Override
            public RequestHandler configHandler() {
                return null;
            }

            @Override
            public long configConnectTimeoutMills() {
                return 0;
            }

            @Override
            public long configReadTimeoutMills() {
                return 0;
            }

            @Override
            public boolean configLogEnable() {
                return true;
            }

            @Override
            public boolean handleError(NetError error) {
                return false;
            }

            @Override
            public boolean dispatchProgressEnable() {
                return false;
            }
        });
    }

    @Override
    protected void initConfig() throws Exception {

    }

    @Override
    protected void initConfigThread() throws Exception {

    }

    public static Context getContext() {
        return context;
    }
}
