package com.hello.baseproject.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.hello.baseproject.R;
import com.hello.baseproject.base.RVBaseViewHolder;
import com.hello.baseproject.utils.ConstantUtil;
import com.hello.baseproject.utils.DisplayUtil;



public class LoadMoreCell extends AbsStateCell {
    public static final int mDefaultHeight = 80;//dp
    public LoadMoreCell(Object o) {
        super(o);
    }

    @Override
    public int getItemType() {
        return ConstantUtil.LOAD_MORE_TYPE;
    }


    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        // 设置LoadMore View显示的默认高度
        setHeight(DisplayUtil.dp2px(context,mDefaultHeight));
        return LayoutInflater.from(context).inflate(R.layout.cell_load_more_layout,null);
    }
}
