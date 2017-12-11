package com.mitime.modules.menu.merchant;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.library.widgets.ui_base.BaseFragment;
import com.mitime.R;
import com.mitime.mvvm.beans.HomePageBeans;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

;

/**
 * 商家Fragment
 */
public class MerchantFragment extends BaseFragment {


    Unbinder unbinder;
    CommonAdapter adapter = null;
    HeaderAndFooterWrapper  mHeaderAndFooterWrapper;
    // MultiItemTypeAdapter
   List<Integer> data = new ArrayList<Integer>();
    @BindView(R.id.mRecycleMerchant)
    RecyclerView mRecycleMerchant;

    public MerchantFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_merchant, container, false);
        unbinder = ButterKnife.bind(this, view);
        //initView();
        return view;
    }

    private void initView() {
       // mRecycleMerchant.setLayoutManager(new GridLayoutManager(getContext(), 4));
       for (int i = 0; i < 8; i++) {
            data.add(i);
        }
    adapter=new CommonAdapter(getContext(), R.layout.merchant_commomitem_layout,data) {
        @Override
        protected void convert(ViewHolder holder, Object o, int position) {

        }
    };
        mHeaderAndFooterWrapper=new HeaderAndFooterWrapper(adapter);
        TextView t1 = new TextView(getContext());
        t1.setText("Header 1");
        mHeaderAndFooterWrapper.addHeaderView(t1);
        mRecycleMerchant.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycleMerchant.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
