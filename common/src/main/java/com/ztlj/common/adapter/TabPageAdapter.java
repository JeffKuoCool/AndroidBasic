package com.ztlj.common.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @date: 2019-10-08
 * @autror: guojian
 * @description:
 */
public class TabPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public TabPageAdapter(@NonNull FragmentManager fm,  List<Fragment> fragments) {
        super(fm, 0);
        mFragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
