package com.library.widgets.views.banner;

import android.content.Context;
import android.view.View;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/7 14:38<br/>
 * 邮箱：1050629507@qq.com
 */
public interface  BannerViewHolder<T> {
    /**
     * 创建View
     * @param mContext
     * @return
     */
    View createView(Context mContext);

    /**
     * 绑定数据
     * @param mContext
     * @param position
     * @param data
     */
    void onBind(Context mContext, int position ,T data);
}
