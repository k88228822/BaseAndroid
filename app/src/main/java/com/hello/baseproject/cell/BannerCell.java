package com.hello.baseproject.cell;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.hello.baseproject.R;
import com.hello.baseproject.base.RVBaseViewHolder;
import com.hello.baseproject.entity.RVItem;

/**
 * Created by wangzhen on 2017/4/28.
 */

public class BannerCell extends BaseCell {
    private RVItem item;
    private BannerImpl bannerImpl=null;

    public interface BannerImpl{
        void setPage(RVBaseViewHolder holder);
    }

    public BannerCell(RVItem o) {
        super(o);
        item=o;
    }

    public void setBannerImpl(BannerImpl bannerImpl) {
        this.bannerImpl = bannerImpl;
    }

    @Override
    public int getItemType() {
        return item.getType();
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_banner,null));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        SliderLayout layout=(SliderLayout)holder.getView(R.id.slider);

    }

}
