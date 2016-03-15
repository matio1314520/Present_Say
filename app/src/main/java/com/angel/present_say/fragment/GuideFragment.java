package com.angel.present_say.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.activity.SearchActivity;
import com.angel.present_say.adapter.GuidePagerAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.GuideTab;
import com.angel.present_say.common.GuideConstant;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/1/29.
 */
@ContentView(R.layout.fragment_guide)
public class GuideFragment extends BaseFragment implements xHttpUtils.Callback {

    @ViewInject(R.id.viewpager_fragment_guide)
    private ViewPager mGuideVip;





    @ViewInject(R.id.tab_fragment_guide)
    private TabLayout mGuideTab;

    private ArrayList<String> mTitleList = new ArrayList<>();

    public static GuideFragment newInstance() {
        GuideFragment fragment = new GuideFragment();
        return fragment;
    }

    @Override
    public void requestNetData() {

        xHttpUtils.get(GuideConstant.CHANNEL_GET_URL, this);
    }

    @Override
    public void initData() {
        //nothing



    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void get(String result) {

        ArrayList<Fragment> fragmentList = new ArrayList<>();//数据源

        GuideTab tab = JSONObject.parseObject(result, GuideTab.class);

        if (tab != null) {

            List<GuideTab.GuideTabData.GuideCandidates> guideCandidatesList = tab.getData().getCandidates();

            if (guideCandidatesList != null) {
                //设置TabLayout文本
                for (int i = 0, size = guideCandidatesList.size(); i < size; i++) {

                    mTitleList.add(guideCandidatesList.get(i).getName());

                    int id = guideCandidatesList.get(i).getId();

                    if (i == 0) {

                        fragmentList.add(GuideChildFragment.newInstance(id, true,null));

                    } else {

                        fragmentList.add(GuideChildFragment.newInstance(id, false,null));
                    }
                }
            }

            //设置适配器
            mGuideVip.setAdapter(new GuidePagerAdapter(getChildFragmentManager(), fragmentList, mTitleList));
        }

        //设置联动
        mGuideTab.setupWithViewPager(mGuideVip);
    }


    @Event({R.id.search_fragment_guide})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.search_fragment_guide:
                startActivity(new Intent(getActivity(), SearchActivity.class));
        }
    }
}