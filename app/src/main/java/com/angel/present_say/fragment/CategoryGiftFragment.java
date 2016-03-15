package com.angel.present_say.fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.adapter.CategoryGiftLeftAdapter;
import com.angel.present_say.adapter.CategoryGiftRightAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.CategoryGift;
import com.angel.present_say.common.CategoryConstant;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
@ContentView(R.layout.fragment_gift_category)
public class CategoryGiftFragment extends BaseFragment implements xHttpUtils.Callback {

    @ViewInject(R.id.listview_left_category_gift)
    private ListView leftListView;

    @ViewInject(R.id.listview_right_category_gift)
    private  ListView rightListView;

    private List<String> nameList = new ArrayList<>();  // 左边listview数据源

    private List<CategoryGift.CategoryGiftData.CategoryGiftCategories> subList = new ArrayList<>(); //右边listview数据源

    private CategoryGiftLeftAdapter adapter; //左边的listv适配器

    private CategoryGiftRightAdapter listAdapter;  //右边的listv适配器

    public static CategoryGiftFragment newInstance() {

        Bundle args = new Bundle();

        CategoryGiftFragment fragment = new CategoryGiftFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void requestNetData() {
        xHttpUtils.get(CategoryConstant.GIFT_GET_URL,this);
    }

    @Override
    public void initData() {

    }

    /**
     * 设置listview适配器
     */
    @Override
    public void setAdapter() {
        adapter = new CategoryGiftLeftAdapter(getActivity(), nameList);
        leftListView.setAdapter(adapter);

        listAdapter = new CategoryGiftRightAdapter(getActivity(), subList);
        rightListView.setAdapter(listAdapter);
    }


    @Override
    public void get(String result) {
        CategoryGift.CategoryGiftData giftData = JSONObject.parseObject(result, CategoryGift.class).getData();
        if (giftData != null) {
            for (CategoryGift.CategoryGiftData.CategoryGiftCategories category : giftData.getCategories()) {
                nameList.add(category.getName());
            }
            subList.addAll(giftData.getCategories());
        }
        adapter.notifyDataSetChanged();
    }
}
