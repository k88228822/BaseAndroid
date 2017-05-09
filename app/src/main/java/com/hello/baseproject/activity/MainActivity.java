package com.hello.baseproject.activity;

import android.os.Bundle;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hello.baseproject.R;
import com.hello.baseproject.adapter.MainViewPagerAdapter;
import com.hello.baseproject.base.BaseActivity;
import com.hello.baseproject.entity.TabEntity;
import com.hello.baseproject.utils.StatusBarUtil;
import com.hello.baseproject.widget.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity{
    @BindView(R.id.tableLayout)
    CommonTabLayout tabLayout;
    @BindView(R.id.viewpage)
    NoScrollViewPager viewpager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        viewpager.setOffscreenPageLimit(4);
        viewpager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
//        viewpager.setCanScroll(false);
        ArrayList<CustomTabEntity> tabEntities=new ArrayList<>();
        tabEntities.add(new TabEntity("主页", R.drawable.icon_home_press,R.drawable.icon_home));
        tabEntities.add(new TabEntity("热卖",R.drawable.icon_hot_press,R.drawable.icon_hot));
        tabEntities.add(new TabEntity("分类",R.drawable.icon_discover_press,R.drawable.icon_discover));
        tabEntities.add(new TabEntity("购物车",R.drawable.icon_cartfill_press,R.drawable.icon_cart));
        tabEntities.add(new TabEntity("我的",R.drawable.icon_user_press,R.drawable.icon_user));
        tabLayout.setTabData(tabEntities);
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    public void initToolBar() {
        StatusBarUtil.from(this).setTransparentStatusbar(true);
    }

}
