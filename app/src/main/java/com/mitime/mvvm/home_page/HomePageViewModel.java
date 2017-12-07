package com.mitime.mvvm.home_page;

import android.support.v7.widget.LinearLayoutManager;

import com.library.widgets.mvvm_base.ViewModel;
import com.mitime.databinding.FragmentHomePageBinding;
import com.mitime.modules.menu.comm_sub.item_view.BannerItemView;
import com.mitime.modules.menu.comm_sub.item_view.DesenoItemView;
import com.mitime.modules.menu.comm_sub.item_view.PromotionItemView;
import com.mitime.modules.menu.comm_sub.item_view.RecommendItemView;
import com.mitime.mvvm.beans.HomePageBeans;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 21:35<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePageViewModel extends ViewModel<HomePageModel> {
    FragmentHomePageBinding mBinding;

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
            mAdapter.addItemViewDelegate(new BannerItemView());
            mAdapter.addItemViewDelegate(new PromotionItemView());
            mAdapter.addItemViewDelegate(new DesenoItemView());
            mAdapter.addItemViewDelegate(new RecommendItemView());
            mBinding.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mBinding.mRecyclerView.setAdapter(mAdapter);
        });


    }



    List<HomePageBeans> getDatas() {
        List<HomePageBeans> mDatas = new ArrayList<>();
        mDatas.add(new HomePageBeans<String[]>(0, new String[]{}));
        mDatas.add(new HomePageBeans<HashMap<String, Object>>(1, new HashMap<>()));
        mDatas.add(new HomePageBeans<Object>(2, new Object()));
        mDatas.add(new HomePageBeans<Object>(3, new Object()));
        mDatas.add(new HomePageBeans<Object>(3, new Object()));
        mDatas.add(new HomePageBeans<Object>(3, new Object()));
        mDatas.add(new HomePageBeans<Object>(3, new Object()));
        return mDatas;
    }


    public  enum  ViewType{
        /**
         *  Banner 专区样式
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
        private  int type;

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
