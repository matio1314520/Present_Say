package com.angel.present_say.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.angel.present_say.R;
import com.angel.present_say.adapter.GuidePagerAdapter;
import com.angel.present_say.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Angel on 2016/3/15.
 */
@ContentView(R.layout.fragment_searchchild)
public class SearchChildFragment extends BaseFragment {

    @ViewInject(R.id.tab_fragment_searchchild)
    private TabLayout mSearchTab;

    @ViewInject(R.id.viewpager_fragment_searchchild)
    private ViewPager mSearchVip;

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();

    private ArrayList<String> titleList = new ArrayList<>();

    private String mKeyword;

    public SearchChildFragment() {

    }

    public static SearchChildFragment newInstance(String content) {

        Bundle args = new Bundle();

        args.putString("content", content);

        SearchChildFragment fragment = new SearchChildFragment();

        fragment.setArguments(args);

        return fragment;
    }

    //http://api.liwushuo.com/v2/items?limit=20&offset=0&gender=1&generation=4  hot

    //http://api.liwushuo.com/v2/search/item?limit=20&offset=0&sort=&keyword=%E9%9B%B6%E9%A3%9F
    @Override
    public void requestNetData() {
        if (getArguments() != null) {

            String content = getArguments().getString("content");
            if (content != null) {
                mKeyword = URLEncoder.encode(content);
            }
        }
    }

    @Override
    public void initData() {

        titleList.add("礼物");
        titleList.add("攻略");

        mFragmentList.add(GridFragment.newInstance(mKeyword));

        mFragmentList.add(GuideChildFragment.newInstance(0, false,mKeyword));
    }

    @Override
    public void setAdapter() {

        mSearchVip.setAdapter(new GuidePagerAdapter(getChildFragmentManager(), mFragmentList, titleList));

        mSearchTab.setTabMode(TabLayout.MODE_FIXED);

        mSearchTab.setupWithViewPager(mSearchVip);
    }

    @Override
    public void get(String result) {

    }
}
