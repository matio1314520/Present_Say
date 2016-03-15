package com.angel.present_say.fragment;

import android.support.design.widget.TabLayout;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.CategorySubject;
import com.angel.present_say.common.CategoryConstant;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
@ContentView(R.layout.header_category_layout)
public class StrategyHeaderFragment extends BaseFragment {

    @ViewInject(value = R.id.ad_header_category)
    private TabLayout subjectTab;

    public static StrategyHeaderFragment newInstance() {
        StrategyHeaderFragment fragment = new StrategyHeaderFragment();

        return fragment;
    }


    @Override
    public void requestNetData() {
        xHttpUtils.get(CategoryConstant.AD_URL_GET,this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void get(String result) {
        CategorySubject subject = JSONObject.parseObject(result, CategorySubject.class);
        if (subject != null) {
            List<CategorySubject.CategoryData.CategoryCollections> collections = subject.getData().getCollections();
            //设置TabLayout文本
            for (int i = 0, size = collections.size(); i < size; i++) {
                ImageView imageView = new ImageView(getActivity());
                x.image().bind(imageView, collections.get(i).getBanner_image_url());
                subjectTab.addTab(subjectTab.newTab().setCustomView(imageView));
            }
        }
    }
}
