package com.hello.baseproject.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangzhen on 2017/4/9.
 */

public class RVItem {
    private int type;
    private Map<String,Integer> imgIDs;
    private Map<String,String> imgUrls;
    private Map<String,Integer> txtIDs;
    private Map<String,String> txtContent;

    public RVItem(int type) {
        this.type=type;
        imgIDs=new HashMap<>();
        imgUrls=new HashMap<>();
        txtContent=new HashMap<>();
        txtIDs=new HashMap<>();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Map<String, Integer> getImgIDMap() {
        return imgIDs;
    }

    public Map<String, String> getImgUrlMap() {
        return imgUrls;
    }

    public Map<String, String> getTxtMap() {
        return txtContent;
    }

    public Map<String, Integer> getTxtIDMap() {
        return txtIDs;
    }

}
