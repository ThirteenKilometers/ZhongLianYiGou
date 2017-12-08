package com.mitime.modules.menu.merchant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mitime.R;
import com.mitime.mvvm.beans.HomePageBeans;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

public class MerchantsClassificationActivity implements ItemViewDelegate<HomePageBeans> {



    @Override
    public int getItemViewLayoutId() {
        return R.layout.classification_item;
    }

    @Override
    public boolean isForViewType(HomePageBeans item, int position) {
        return  item.getItemType()==0;
    }

    @Override
    public void convert(ViewHolder holder, HomePageBeans homePageBeans, int position) {

    }
}
