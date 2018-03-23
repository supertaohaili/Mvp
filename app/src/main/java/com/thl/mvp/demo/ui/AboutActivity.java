package com.thl.mvp.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.thl.mvp.mvp.XActivity;
import com.thl.mvp.router.Router;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wanglei on 2016/12/31.
 */

public class AboutActivity extends XActivity {
    @BindView(com.thl.mvp.demo.R.id.toolbar)
    Toolbar toolbar;


    @Override
    public void initData(Bundle savedInstanceState) {
        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(com.thl.mvp.demo.R.drawable.ic_arrow_white_24dp);
        getSupportActionBar().setTitle("关于XDroidMvp");
    }

    @OnClick({
            com.thl.mvp.demo.R.id.tv_githubMvc,
            com.thl.mvp.demo.R.id.tv_githubMvp
    })
    public void clickEvent(View view) {
        switch (view.getId()) {

            case com.thl.mvp.demo.R.id.tv_githubMvc:
                WebActivity.launch(context, "https://github.com/limedroid/XDroid", "XDroid");
                break;

            case com.thl.mvp.demo.R.id.tv_githubMvp:
                WebActivity.launch(context, "https://github.com/limedroid/XDroidMvp", "XDroid");
                break;
        }
    }

    public static void launch(Activity activity) {
        Router.newIntent(activity)
                .to(AboutActivity.class)
                .data(new Bundle())
                .launch();
    }

    @Override
    public int getLayoutId() {
        return com.thl.mvp.demo.R.layout.activity_about;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
