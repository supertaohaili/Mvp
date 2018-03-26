package com.thl.mvp.demo.ui;

import com.thl.mvp.base.RecyclerItemCallback;
import com.thl.mvp.base.SimpleRecAdapter;
import com.thl.mvp.demo.adapter.GirlAdapter;
import com.thl.mvp.demo.model.GankResults;


import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created on 2016/12/31.
 */

public class GirlFragment extends BasePagerFragment {

    GirlAdapter adapter;

    @Override
    public SimpleRecAdapter getAdapter() {
        if (adapter == null) {
            adapter = new GirlAdapter(context);
            adapter.setRecItemClick(new RecyclerItemCallback<GankResults.Item, GirlAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, GankResults.Item model, int tag, GirlAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);
                }
            });
        }
        return adapter;
    }

    @Override
    public void setLayoutManager(XRecyclerView recyclerView) {
        recyclerView.gridLayoutManager(context, 2);
    }

    @Override
    public String getType() {
        return "福利";
    }

    public static GirlFragment newInstance() {
        return new GirlFragment();
    }

}
