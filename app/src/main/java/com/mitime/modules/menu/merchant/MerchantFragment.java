package com.mitime.modules.menu.merchant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.library.widgets.ui_base.BaseFragment;
import com.mitime.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 商家Fragment
 */
public class MerchantFragment extends BaseFragment {


    @BindView(R.id.MerchantsClassification)
    RecyclerView MerchantsClassification;//商家分类
    @BindView(R.id.MerchantsRecommend)
    RecyclerView MerchantsRecommend;//推荐商家
    Unbinder unbinder;
    CommonAdapter adapter=null;
   // MultiItemTypeAdapter
    List<Integer>data=new ArrayList<Integer>();

    public MerchantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_merchant, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        MerchantsClassification.setLayoutManager(new GridLayoutManager(getContext(),4));
        for (int i = 0; i < 8; i++) {
            data.add(i);
        }
        adapter= new CommonAdapter<Integer>(getContext(), R.layout.classification_item, data) {
            

            @Override
            protected void convert(ViewHolder holder, Integer integer, int position) {


            }
        } ;
        
        /*//classification_item
        adapter=new CommonAdapter<Integer>(getContext(), R.layout.recommend_item,data) {

            @Override
            protected void convert(ViewHolder holder, Integer integer, int position) {

            }
        };*/
        MerchantsClassification.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
