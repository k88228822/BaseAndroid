package com.hello.baseproject.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.hello.baseproject.R;
import com.hello.baseproject.base.RVBaseViewHolder;
import com.hello.baseproject.utils.ConstantUtil;

public class ErrorCell extends AbsStateCell {
    public ErrorCell(Object o) {
        super(o);
    }

    @Override
    public int getItemType() {
        return ConstantUtil.ERROR_TYPE;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.cell_error_layout,null);
    }

}
