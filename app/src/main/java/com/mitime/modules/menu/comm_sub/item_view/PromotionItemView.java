package com.mitime.modules.menu.comm_sub.item_view;

import android.view.View;

import com.library.utils.ToastUtil;
import com.library.utils.Utils;
import com.mitime.R;
import com.mitime.mvvm.beans.HomePageBeans;
import com.mitime.mvvm.home_page.HomePageViewModel;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * 活动专区样式<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 21:35<br/>
 * 邮箱：1050629507@qq.com
 */
public class PromotionItemView implements ItemViewDelegate<HomePageBeans> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_promotion_layout;
    }

    @Override
    public boolean isForViewType(HomePageBeans item, int position) {
        return item.getItemType() == HomePageViewModel.ViewType.Promotion.getType();
    }

    @Override
    public void convert(ViewHolder holder, HomePageBeans homePageBeans, int position) {
        AutoUtils.auto(holder.getConvertView());
        OnClickListener clickListener = new OnClickListener();
        holder.setOnClickListener(R.id.mViewMore, clickListener);
        holder.setOnClickListener(R.id.mViewSeckill, clickListener);
        holder.setOnClickListener(R.id.mViewExchange, clickListener);
        holder.setOnClickListener(R.id.mViewRedPacket, clickListener);
    }

    class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (Utils.isContinuous()) return;
            String vla = "";
            switch (v.getId()) {
                case R.id.mViewSeckill:
                    //一元秒杀
                    vla = "一元秒杀";
                    break;
                case R.id.mViewExchange:
                    //免费兑换
                    vla = "免费兑换";
                    break;
                case R.id.mViewRedPacket:
                    //红包专区
                    vla = "红包专区";
                    break;
                case R.id.mViewMore:
                    //更多活动
                    vla = "更多活动";
                    break;
            }

            ToastUtil.INSTANCE.show(v.getContext(), vla);

        }
    }
}
   