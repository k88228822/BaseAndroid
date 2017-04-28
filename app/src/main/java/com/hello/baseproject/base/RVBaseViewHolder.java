package com.hello.baseproject.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by wangzhen
 */

public class RVBaseViewHolder extends RecyclerView.ViewHolder{
    private SparseArray<View> views;
    private View mItemView;
    public RVBaseViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        mItemView = itemView;

    }

    /**
     * 获取ItemView
     * @return
     */
    public View getItemView() {
        return mItemView;
    }

    public View getView(int resId) {
        return retrieveView(resId);
    }

    public TextView getTextView(int resId){
        return retrieveView(resId);
    }


    public SimpleDraweeView getSimpleDraweeView(int resId){return retrieveView(resId);}

    public Button getButton(int resId){
        return retrieveView(resId);
    }

    @SuppressWarnings("unchecked")
    protected <V extends View> V retrieveView(int viewId){
        View view = views.get(viewId);
        if(view == null){
            view = mItemView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (V) view;
    }

    public void setText(int resId,CharSequence text){
          getTextView(resId).setText(text);
    }

    public void setText(int resId,int strId){getTextView(resId).setText(strId);}

    public void setSimpleDraweeViewUri(int resId,String uri){getSimpleDraweeView(resId).setImageURI(uri);}
}
