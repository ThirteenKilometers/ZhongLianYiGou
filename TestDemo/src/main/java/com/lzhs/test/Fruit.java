package com.lzhs.test;

/**
 * @author ${俞欢} QQ:2366081200
 * @name ZhongLianYiGou
 * @class describe:
 * @time 2017/12/10 16:52
 * @chang time
 * @change class describe:
 */

public class Fruit {
    private  String name;
    private  int ImgId;
    private  int type;

    public Fruit(String name, int imgId, int type) {
        this.name = name;
        ImgId = imgId;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Fruit(String name, int imgId) {
        this.name = name;
        ImgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }
}
