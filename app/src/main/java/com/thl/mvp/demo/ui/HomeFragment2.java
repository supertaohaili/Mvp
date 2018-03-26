package com.thl.mvp.demo.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.thl.mvp.base.RecyclerItemCallback;
import com.thl.mvp.base.SimpleRecAdapter;
import com.thl.mvp.demo.adapter.HomeAdapter;
import com.thl.mvp.demo.model.GankResults;
import com.thl.mvp.demo.present.PBasePager;
import com.thl.mvp.demo.present.PBasePager2;
import com.thl.mvp.mvp.IPresent;
import com.thl.mvp.mvp.ListFragment;
import com.thl.mvp.net.NetError;

import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created on 2016/12/31.
 */

public class HomeFragment2 extends ListFragment<PBasePager2> {

    private int page = 1;

    @Override
    public void initData(Bundle savedInstanceState) {

        getP().loadData(getType(), page);
    }

    @Override
    protected void refresh(TwinklingRefreshLayout refreshLayout) {
        super.refresh(refreshLayout);
        page = 1;
        getP().loadData(getType(), page);
    }

    @Override
    protected void loadMore(TwinklingRefreshLayout refreshLayout) {
        super.loadMore(refreshLayout);
        getP().loadData(getType(), page);
    }

    @Override
    public PBasePager2 newP() {
        return new PBasePager2();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Override
    protected SimpleRecAdapter initAdapter() {
        if (adapter == null) {
            adapter = new HomeAdapter(context);
            adapter.setRecItemClick(new RecyclerItemCallback<GankResults.Item, HomeAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, GankResults.Item model, int tag, HomeAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);
                    switch (tag) {
                        case HomeAdapter.TAG_VIEW:
                            WebActivity.launch(context, model.getUrl(), model.getDesc());
                            break;
                    }
                }
            });
        }
        return adapter;
    }

    HomeAdapter adapter;

    //    @Override
    public String getType() {
        return "all";
    }

    public void showError(NetError error) {
        showError();
//        if (error != null) {
//          showError();
//        }
    }

    public void showData(int page, GankResults model) {
        if (page > 1) {
            getAdapter().addData(model.getResults());
            finishLoadmore();
        } else {
            getAdapter().setData(model.getResults());
            finishRefreshing();
        }
        this.page = page+1;

        if (getAdapter().getItemCount() < 1) {
            showEmpty();
            return;
        }else{
            showContent();
        }
    }


    public static HomeFragment2 newInstance() {
        return new HomeFragment2();
    }


}
