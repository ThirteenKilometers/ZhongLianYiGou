package com.mitime.mvvm.beans;

/**
 * <br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/5 16:39<br/>
 * 邮箱：1050629507@qq.com
 */
public class PromotionBean {
    int id=-1;
    String name;
    String imageUrl;
    int imageRes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
