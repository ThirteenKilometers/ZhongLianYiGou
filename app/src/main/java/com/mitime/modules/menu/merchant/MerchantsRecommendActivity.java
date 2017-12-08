package com.mitime.modules.menu.merchant;

import com.mitime.R;
import com.mitime.mvvm.beans.HomePageBeans;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * describe:
 * QQ: 2366081200
 * Created by pc1 on 2017/12/8.
 */

class MerchantsRecommendActivity implements com.zhy.adapter.recyclerview.base.ItemViewDelegate<HomePageBeans> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.recommend_item;
    }

    @Override
    public boolean isForViewType(HomePageBeans item, int position) {
        return item.getItemType()==1;
    }

    @Override
    public void convert(ViewHolder holder, HomePageBeans homePageBeans, int position) {

    }
}
