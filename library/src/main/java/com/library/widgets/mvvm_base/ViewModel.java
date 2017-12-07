package com.library.widgets.mvvm_base;

import android.content.Context;

import com.library.widgets.ui_base.BaseActivity;
import com.library.widgets.ui_base.BaseFragment;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/11/29 17:26<br/>
 * 邮箱：1050629507@qq.com
 */
public abstract class ViewModel<M extends Model> implements BaseActivity.ActivityFlow {
    public Context mContext;

    public M mModel;

    public void onCreate(BaseActivity mActivity) {
        setContext(mActivity);
    }

    public void onCreateView() {
    }

    public M createModel() {
        return null;
    }

    public void onCreate(BaseFragment mFragment) {
        setContext(mFragment.getContext());
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
        this.mModel = createModel();
        this.onCreate();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onRestart() {

    }
}
