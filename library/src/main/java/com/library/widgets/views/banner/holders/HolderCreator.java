package com.library.widgets.views.banner.holders;

/**
 * Created by zhouwei on 17/5/26.
 */

public interface HolderCreator<VH extends ViewHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    public VH createViewHolder();
}
