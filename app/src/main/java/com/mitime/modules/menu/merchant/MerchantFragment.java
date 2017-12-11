package com.mitime.modules.menu.merchant;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.library.widgets.ui_base.BaseFragment;
import com.mitime.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
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
    HeaderAndFooterWrapper mHeaderAndFooterWrapper;
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
        initView();
        return view;
    }

    private void initView() {
        // mRecycleMerchant.setLayoutManager(new GridLayoutManager(getContext(), 4));
        for (int i = 0; i < 8; i++) {
            data.add(i);
        }
        adapter = new CommonAdapter(getContext(), R.layout.merchant_commomitem_layout, data) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                AutoUtils.auto(holder.getConvertView());

            }
        };
        initHeadAndFooter();
        mRecycleMerchant.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycleMerchant.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();
    }

    private void initHeadAndFooter() {
      mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(adapter);//classification_item

        FrameLayout mRoot=new FrameLayout(getContext());
        mRoot.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        View view=LayoutInflater.from(getContext()).inflate(R.layout.classification,mRoot,false);

        RecyclerView mRecycleClassification=view.findViewById(R.id.mRecycleClassification);
        mRecycleClassification.setLayoutManager(new GridLayoutManager(getContext(),4));
        mRecycleClassification.setAdapter(new CommonAdapter(getContext(),R.layout.classification_item,data) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                AutoUtils.auto(holder.getConvertView());

            }

        });
        mRoot.addView(view);
        mHeaderAndFooterWrapper.addHeaderView(mRoot);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
