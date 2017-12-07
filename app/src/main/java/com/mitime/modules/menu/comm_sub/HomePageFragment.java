package com.mitime.modules.menu.comm_sub;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.library.widgets.ui_base.BaseFragment;
import com.mitime.R;
import com.mitime.databinding.FragmentHomePageBinding;
import com.mitime.mvvm.home_page.HomePageViewModel;

/**
 * 首页Fragment页面<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 21:24<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePageFragment extends BaseFragment<HomePageViewModel> {
    FragmentHomePageBinding mBinding;

    public static HomePageFragment newInstance() {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false);
        mViewModel.setBinding(mBinding);
        super.onCreateView(inflater, container, savedInstanceState);
        return mBinding.getRoot();
    }

    @Override
    protected HomePageViewModel createViewModel() {
        return new HomePageViewModel();
    }
}
