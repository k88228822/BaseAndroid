package com.hello.baseproject.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.hello.baseproject.R;
import com.hello.baseproject.base.RVBaseViewHolder;
import com.hello.baseproject.utils.ConstantUtil;

public class EmptyCell extends AbsStateCell {

    public EmptyCell(Object o) {
        super(o);
    }


    @Override
    public int getItemType() {
        return ConstantUtil.EMPTY_TYPE;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.cell_empty_layout,null);
    }
}
