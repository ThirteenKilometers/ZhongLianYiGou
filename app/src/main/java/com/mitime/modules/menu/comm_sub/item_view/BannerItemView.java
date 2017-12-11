package com.mitime.modules.menu.comm_sub.item_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.library.utils.ToastUtil;
import com.library.widgets.views.banner.BannerView;
import com.mitime.R;
import com.mitime.mvvm.beans.HomePageBeans;
import com.mitime.mvvm.home_page.HomePageViewModel;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Banner 专区样式<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 21:35<br/>
 * 邮箱：1050629507@qq.com
 */
public class BannerItemView implements ItemViewDelegate<HomePageBeans> {
    List<Integer> banners = new ArrayList<>();
    BannerView mBannerView;

    public BannerItemView() {
        banners.add(R.mipmap.banner_01);
        banners.add(R.mipmap.banner_02);
        banners.add(R.mipmap.banner_03);

    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_banner_layout;
    }

    @Override
    public boolean isForViewType(HomePageBeans item, int position) {
        return item.getItemType() == HomePageViewModel.ViewType.Banner.getType();

    }

    @Override
    public void convert(ViewHolder holder, HomePageBeans homePageBeans, int position) {
        AutoUtils.auto(holder.getConvertView());
        mBannerView = holder.getView(R.id.mBannerView);
        mBannerView.setPages(banners, () -> new BannerViewHolders());
        mBannerView.setBannerPageClickListener((view, position1) -> ToastUtil.INSTANCE.show(holder.getConvertView().getContext(), "你单击了第 " + position1 + "张Banner"));

        mBannerView.start();
    }

    public static class BannerViewHolders implements com.library.widgets.views.banner.holders.ViewHolder<Integer> {
        private ImageView mImageView;

        @Override
        public View createView(Context mContext) {
            View mRoot = LayoutInflater.from(mContext).inflate(R.layout.banner_item01, null);
            mImageView = mRoot.findViewById(R.id.mImageView);
            return mRoot;
        }

        @Override
        public void onBind(Context mContext, int position, Integer data) {
            mImageView.setImageResource(data);
        }
    }


    public void onPause() {
        if (mBannerView == null)
            mBannerView.pause();
    }
}