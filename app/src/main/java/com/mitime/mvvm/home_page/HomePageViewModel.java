package com.mitime.mvvm.home_page;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.library.widgets.mvvm_base.ViewModel;
import com.mitime.R;
import com.mitime.databinding.FragmentHomePageBinding;
import com.mitime.modules.menu.comm_sub.item_view.BannerItemView;
import com.mitime.modules.menu.comm_sub.item_view.DesenoItemView;
import com.mitime.modules.menu.comm_sub.item_view.PromotionItemView;
import com.mitime.modules.menu.comm_sub.item_view.RecommendItemView;
import com.mitime.mvvm.beans.HomePageBeans;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 21:35<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePageViewModel extends ViewModel<HomePageModel> {
    FragmentHomePageBinding mBinding;
    BannerItemView mBannerItemView = new BannerItemView();

    @Override
    public HomePageModel createModel() {
        return new HomePageModel(mContext);
    }

    public void setBinding(FragmentHomePageBinding binding) {
        this.mBinding = binding;
    }

    @Override
    public void onCreateView() {
        mBinding.mMultipleStatusView.showLoading();
        mModel.getDatas().subscribe(aLong -> {

            mBinding.mMultipleStatusView.showContent();
            MultiItemTypeAdapter mAdapter = new MultiItemTypeAdapter(mContext, getDatas());


            android.view.View mRoot = LayoutInflater.from(mContext).inflate(R.layout.activity_menu, null, false);


            RecyclerView mRecyclerView = mRoot.findViewById(R.id.mRecyclerView);
            mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));


            mAdapter.addItemViewDelegate(mBannerItemView);
            mAdapter.addItemViewDelegate(new PromotionItemView());
            mAdapter.addItemViewDelegate(new DesenoItemView());
            mAdapter.addItemViewDelegate(new RecommendItemView());
            mBinding.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mBinding.mRecyclerView.setAdapter(mAdapter);
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mBannerItemView != null) mBannerItemView.onPause();

    }

    List<HomePageBeans> getDatas() {
        List<HomePageBeans> mDatas = new ArrayList<>();
        mDatas.add(new HomePageBeans<String[]>(ViewType.Banner.getType(), null));

        mDatas.add(new HomePageBeans<String>(ViewType.Promotion.getType(), ""));

        mDatas.add(new HomePageBeans<Object>(ViewType.Deseno.getType(), new Object()));

        mDatas.add(new HomePageBeans<Object>(ViewType.Recommend.getType(), new Object()));
        mDatas.add(new HomePageBeans<Object>(ViewType.Recommend.getType(), new Object()));
        mDatas.add(new HomePageBeans<Object>(ViewType.Recommend.getType(), new Object()));
        mDatas.add(new HomePageBeans<Object>(ViewType.Recommend.getType(), new Object()));
        return mDatas;
    }


    public enum ViewType {
        /**
         * Banner 专区样式
         */
        Banner(0),
        /**
         * 活动专区样式
         */
        Promotion(1),
        /**
         * 限时抢购专区样式
         */
        Deseno(2),
        /**
         * 精品推荐专区样式
         */
        Recommend(3);
        private int type;

        ViewType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }


}
