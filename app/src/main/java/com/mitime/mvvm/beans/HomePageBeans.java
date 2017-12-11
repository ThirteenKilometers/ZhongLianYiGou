package com.mitime.mvvm.beans;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/4 22:19<br/>
 * 邮箱：1050629507@qq.com
 */
public class HomePageBeans<T> {

    int mItemType = -1;

    T mItemDatas;

    public HomePageBeans() {
        super();
    }

    public HomePageBeans(int mItemType, T mItemDatas) {
        this.mItemType = mItemType;
        this.mItemDatas = mItemDatas;
    }

    public int getItemType() {
        return mItemType;
    }

    public void setItemType(int mItemType) {
        this.mItemType = mItemType;
    }

    public T getItemDatas() {
        return mItemDatas;
    }

    public void setItemDatas(T mItemDatas) {
        this.mItemDatas = mItemDatas;
    }
}
