package com.hello.baseproject.cell;

import android.view.ViewGroup;

import com.hello.baseproject.base.RVBaseViewHolder;

/**
 * Created by wangzhen
 */

public interface Cell {
    /**
     * 回收资源
     *
     */
    public void releaseResource();

    /**
     * 获取viewType
     * @return
     */
    public  int getItemType();

    /**
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    /**
     * 数据绑定
     * @param holder
     * @param position
     */
    public  void onBindViewHolder(RVBaseViewHolder holder, int position);
}
