package com.hello.baseproject.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.PopupWindow;

import com.jakewharton.rxbinding2.view.RxView;


/**
 * Created by wangzhen on 2017/4/12.
 */

public class PopupWindowUtil extends PopupWindow{
    private Context context=null;
    private View contentView=null;
    private int width= ViewGroup.LayoutParams.MATCH_PARENT;
    private int height=ViewGroup.LayoutParams.MATCH_PARENT;
    private boolean focusable=true;
    private AnimationSet startSet=null;
    private AnimationSet endSet=null;

    public PopupWindowUtil(Context context){
        this.context=context;
        this.setContentView(contentView);
        this.setWidth(width);
        this.setHeight(height);
        this.setFocusable(focusable);
    }

    public PopupWindowUtil setContentView(int id){
        contentView= LayoutInflater.from(context).inflate(id,null);
        this.setContentView(contentView);
       return this;
    }

    public PopupWindowUtil setWithNew(int width){
        this.setWidth(width);
        return this;
    }
    public PopupWindowUtil setHeightNew(int height){
        this.setHeight(height);
       return this;
    }

    public PopupWindowUtil setFocusableNew(boolean focusable){
        this.setFocusable(focusable);
        return this;
    }

    public io.reactivex.Observable<Object> setItemOnClickListener(int id){

        return RxView.clicks(contentView.findViewById(id));
    }


    public void closeWindow(){
        this.dismiss();
    }

    /**
     * 根据id获取子view
     * @param id
     * @return
     */
    public View getItemViewById(int id){
       return LayoutInflater.from(context).inflate(id,null);
    }


    //相对某个控件的位置（正左下方），无偏移
    public PopupWindowUtil showAsDropDownNew(View anchor){
        this.showAsDropDown(anchor);
        return this;
    }

    //相对某个控件的位置，有偏移;xoff表示x轴的偏移，正值表示向左，负值表示向右；yoff表示相对y轴的偏移，正值是向下，负值是向上；
    public PopupWindowUtil showAsDropDownNew(View anchor, int xoff, int yoff){
        this.showAsDropDown(anchor,xoff,yoff);
        return this;
    }

    //相对于父控件的位置（例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
    public PopupWindowUtil showAtLocationNew(int parentLayoutId, int gravity, int x, int y){
        View parent=LayoutInflater.from(context).inflate(parentLayoutId,null);
        this.showAtLocation(parent,gravity,x,y);
        return this;
    }


}
