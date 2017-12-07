package com.library.widgets.ui_base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.library.R;
import com.library.utils.StatusBarUtil;
import com.library.widgets.mvvm_base.ViewModel;
import com.zhy.autolayout.AutoLayoutActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * 该类为该应用所有Activity的基类<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/11/27 16:13<br/>
 * 邮箱：1050629507@qq.com
 */
public abstract class BaseActivity<VM extends ViewModel> extends AutoLayoutActivity {

    public final String TAG = this.getClass().getSimpleName();


    protected VM mViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        mViewModel = createViewModel();
        if (mViewModel != null)
            mViewModel.onCreate(this);
    }

    protected VM createViewModel() {
        return mViewModel == null ? null : mViewModel;
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorAccent), Color.TRANSPARENT);
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

    @Override
    public void onRestart() {
        super.onRestart();
        if (mViewModel != null) mViewModel.onRestart();
    }

    /**
     * 该接口为监听Activity生命周期<br/>
     * 作者：LZHS<br/>
     * 时间： 2017/10/23 22:32<br/>
     * 邮箱：1050629507@qq.com
     */
    public interface ActivityFlow {

        void onCreate();

        void onStart();

        void onResume();


        void onPause();

        void onStop();

        void onDestroy();

        void onRestart();
    }
}
