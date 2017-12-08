package com.library.widgets.views.banner;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/7 14:41<br/>
 * 邮箱：1050629507@qq.com
 */
public interface BannerHolderCreater<VH extends  BannerViewHolder> {
    public  VH createViewHolder();
}
