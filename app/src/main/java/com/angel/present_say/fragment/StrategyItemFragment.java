package com.angel.present_say.fragment;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.adapter.CategoryGridAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.CategoryList;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/2/16.
 */
@ContentView(R.layout.item_listivew_category)
public class StrategyItemFragment extends BaseFragment {

    @ViewInject(R.id.allname_listview_category)
    private TextView nameTxt;

    @ViewInject(R.id.gridview_category)
    private GridView gridView;

    private CategoryGridAdapter gridAdapter;

    private List<CategoryList.CategoryDataEntity.CategoryChannelGroups.CategoryChannels> groupses = new ArrayList<>();

    public static StrategyItemFragment newInstance(String result, int position) {

        Bundle args = new Bundle();

        args.putString("result", result);
        args.putInt("position", position);

        StrategyItemFragment fragment = new StrategyItemFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void requestNetData() {
        if (getArguments() != null) {
            CategoryList.CategoryDataEntity data = JSONObject.parseObject(getArguments().getString("result"), CategoryList.class).getData();
            if (data != null) {
                int position = getArguments().getInt("position");
                nameTxt.setText(data.getChannel_groups().get(position).getName());
                groupses.addAll(data.getChannel_groups().get(position).getChannels());
                gridAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {
        gridAdapter = new CategoryGridAdapter(getActivity(), groupses);
        gridView.setAdapter(gridAdapter);
    }

    @Override
    public void get(String result) {

    }
}
