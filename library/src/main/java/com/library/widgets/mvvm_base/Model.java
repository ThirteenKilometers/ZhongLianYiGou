package com.library.widgets.mvvm_base;

import android.content.Context;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/10/23 23:14<br/>
 * 邮箱：1050629507@qq.com
 */
public abstract class Model {

    Context mContext;

    protected Model(Context mContext) {
        this.mContext = mContext;
    }

    protected abstract void onCreate();

    protected abstract void onDestroy();

}
