package com.mitime.modules.menu.comm_sub.item_view;

import com.mitime.R;
import com.mitime.mvvm.beans.HomePageBeans;
import com.mitime.mvvm.home_page.HomePageViewModel;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Banner 专区样式<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 21:35<br/>
 * 邮箱：1050629507@qq.com
 */
public class BannerItemView implements ItemViewDelegate<HomePageBeans> {
        @Override
        public int getItemViewLayoutId() {
            return R.layout.item_banner_layout;
        }

        @Override
        public boolean isForViewType(HomePageBeans item, int position) {
            return item.getItemType()== HomePageViewModel.ViewType.Banner.getType();
        }

        @Override
        public void convert(ViewHolder holder, HomePageBeans homePageBeans, int position) {

        }
    }