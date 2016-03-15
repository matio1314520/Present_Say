package com.angel.present_say.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Angel on 2016/1/29.
 */
public class GuidePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    private List<String> mTilteList;

    public GuidePagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public GuidePagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        this(fm, fragmentList);
        this.mTilteList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList != null ? fragmentList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTilteList != null ? mTilteList.get(position) : null;
    }
}
