package com.hello.baseproject.adapter.decorations;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wangzhen on 2017/4/20.
 */

public class KDItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int itemSpace=0;

    public KDItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        switch (parent.getChildPosition(view)){
            case 1:
                outRect.top=space;
                break;
            case 2:
                outRect.top=space;
                break;
            default:
                outRect.top=itemSpace;
                break;
        }
    }

    public void setItemSpace(int itemSpace){
        this.itemSpace=itemSpace;
    }
}
