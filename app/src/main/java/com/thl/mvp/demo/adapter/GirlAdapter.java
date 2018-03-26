package com.thl.mvp.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.thl.mvp.base.SimpleRecAdapter;
import com.thl.mvp.imageloader.ILFactory;

import butterknife.BindView;

import com.thl.mvp.demo.R;
import com.thl.mvp.demo.model.GankResults;
import com.thl.mvp.kit.KnifeKit;

/**
 * Created on 2016/12/10.
 */

public class GirlAdapter extends SimpleRecAdapter<GankResults.Item, GirlAdapter.ViewHolder> {


    public GirlAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_girl;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GankResults.Item item = data.get(position);

        ILFactory.getLoader().loadNet(holder.ivGirl, item.getUrl(), null);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getRecItemClick() != null) {

                }
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_girl)
        ImageView ivGirl;

        public ViewHolder(View itemView) {
            super(itemView);
            KnifeKit.bind(this, itemView);
        }
    }
}
