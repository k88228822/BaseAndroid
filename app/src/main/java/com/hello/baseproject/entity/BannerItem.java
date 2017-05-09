package com.hello.baseproject.entity;

/**
 * Created by wangzhen on 2017/4/28.
 */

public class BannerItem {
    private int id;
    private String name;
    private String imgUrl;
    private int type;

    public BannerItem() {
        id=0;
        name="";
        imgUrl="";
        type=0;
    }

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BannerItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", type=" + type +
                '}';
    }
}
