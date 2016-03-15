package com.angel.present_say.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.activity.CategoryChildActivity;
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
public class StrategyHeaderFragment extends BaseFragment implements View.OnClickListener {

    @ViewInject(value = R.id.ad_header_category)
    private TabLayout subjectTab;

    private int mId;

    public static StrategyHeaderFragment newInstance() {
        StrategyHeaderFragment fragment = new StrategyHeaderFragment();

        return fragment;
    }


    @Override
    public void requestNetData() {
        xHttpUtils.get(CategoryConstant.AD_URL_GET, this);
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

            //设置TabLayout
            for (int i = 0, size = collections.size(); i < size; i++) {

                ImageView imageView = new ImageView(getActivity());

                mId = collections.get(i).getId();
                imageView.setOnClickListener(this);

                x.image().bind(imageView, collections.get(i).getBanner_image_url());

                subjectTab.addTab(subjectTab.newTab().setCustomView(imageView));
            }
        }
    }

    @Override
    public void onClick(View v) {

        //http://api.liwushuo.com/v2/collections/223/posts?limit=20&offset=0
        Intent intent = new Intent(getActivity(), CategoryChildActivity.class);
        intent.putExtra("id", mId);
        startActivity(intent);


    }
}
