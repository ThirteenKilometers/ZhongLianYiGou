package com.mitime.modules.menu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.library.widgets.ui_base.BaseFragment;
import com.mitime.R;
import com.mitime.databinding.FragmentCommBinding;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/1 12:01<br/>
 * 邮箱：1050629507@qq.com
 */
public class CommFragment extends BaseFragment {

    FragmentCommBinding mBinding ;

    public static CommFragment newInstance(String title){
        CommFragment fragment = new CommFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_comm,container,false);
        mBinding.setTitle(getArguments().getString("title"));
        return mBinding.getRoot();
    }
}
