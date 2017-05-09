package com.hello.baseproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.hello.baseproject.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhen on 2017/4/12.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    public static final int PAGE_COUNT=4;
    public List<Fragment> fragments=new ArrayList<>();

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        for (int i=0;i<PAGE_COUNT;i++) {
            fragments.add(new HomeFragment());
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
