package com.angel.present_say.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.activity.HotItemActivity;
import com.angel.present_say.adapter.HotItemAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.HotGrid;
import com.angel.present_say.common.HotConstant;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/1/29.
 */
@ContentView(R.layout.fragment_hot)
public class HotFragment extends BaseFragment {

    @ViewInject(R.id.gridview_fragment_hot)
    private GridView mGridView;   //GridView

    private HotItemAdapter mAdapter; //适配器

    private ArrayList<HotGrid.HotDataEntity.HotItems.HotData> mHotList = new ArrayList<>(); //数据源

    public static HotFragment newInstance() {

        HotFragment fragment = new HotFragment();
        return fragment;
    }


    @Override
    public void requestNetData() {

        xHttpUtils.get(HotConstant.HOT_URL, this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {
        mAdapter = new HotItemAdapter(getActivity(), mHotList);

        mGridView.setAdapter(mAdapter);
    }

    @Event(value = R.id.gridview_fragment_hot, type = AdapterView.OnItemClickListener.class)
    private void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //页面跳转
        toAnotherActivity(position);

    }

    /**
     * 页面跳转
     */
    private void toAnotherActivity(int position) {

        Intent intent = new Intent(getActivity(), HotItemActivity.class);

        if (mHotList != null && mHotList.size() > 0) {

            intent.putExtra("id", mHotList.get(position).getId());
        }

        startActivity(intent);
    }

    @Override
    public void get(String result) {

        HotGrid hotGrid = JSONObject.parseObject(result, HotGrid.class);

        if (hotGrid != null) {

            List<HotGrid.HotDataEntity.HotItems> hotItemsList = hotGrid.getData().getItems();

            for (HotGrid.HotDataEntity.HotItems items : hotItemsList) {
                mHotList.add(items.getData());
            }
            mAdapter.notifyDataSetChanged();
        }
    }
}
