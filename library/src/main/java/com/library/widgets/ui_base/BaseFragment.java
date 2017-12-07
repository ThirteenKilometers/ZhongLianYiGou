package com.library.widgets.ui_base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.library.widgets.mvvm_base.ViewModel;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/11/27 17:28<br/>
 * 邮箱：1050629507@qq.com
 */
public abstract  class BaseFragment<VM extends ViewModel> extends Fragment {


    public final String TAG = this.getClass().getSimpleName();


    protected VM mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel= createViewModel();
        if (mViewModel != null) mViewModel.onCreate(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mViewModel != null) mViewModel.onCreateView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected VM createViewModel() {
        return mViewModel == null ? null : mViewModel;
    }
    @Override
    public void onStart() {
        super.onStart();
        if (mViewModel != null) mViewModel.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mViewModel != null) mViewModel.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mViewModel != null) mViewModel.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mViewModel != null) mViewModel.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mViewModel != null) mViewModel.onDestroy();
    }


}
