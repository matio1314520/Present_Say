package com.angel.present_say.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.angel.present_say.R;
import com.angel.present_say.activity.SearchActivity;
import com.angel.present_say.adapter.GuidePagerAdapter;
import com.angel.present_say.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/1/29.
 */
@ContentView(R.layout.fragment_category)
public class CategoryFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    @ViewInject(R.id.viewpager_fragment_category)
    private ViewPager viewPager;

    @ViewInject(R.id.rag_category)
    private RadioGroup radioGroup;

    private List<Fragment> fragmentList = new ArrayList<>();

    public static CategoryFragment newInstance() {

        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

    @Override
    public void requestNetData() {

    }

    @Override
    public void initData() {
        fragmentList.add(new CategoryStrategyFragment());

        fragmentList.add(new CategoryGiftFragment());
    }

    @Override
    public void setAdapter() {
        viewPager.setAdapter(new GuidePagerAdapter(getChildFragmentManager(), fragmentList));

        viewPager.addOnPageChangeListener(this);

    }

    @Event(value = R.id.rag_category, type = RadioGroup.OnCheckedChangeListener.class)
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.strategy_radiobutton_category) {
            viewPager.setCurrentItem(0);
        } else if (checkedId == R.id.gift_radiobutton_category) {
            viewPager.setCurrentItem(1);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ((RadioButton) radioGroup.getChildAt(position)).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void get(String result) {

    }


    @Event(R.id.search_fragment_guide)
    private void onClick(View view) {
        startActivity(new Intent(getActivity(), SearchActivity.class));
    }
}