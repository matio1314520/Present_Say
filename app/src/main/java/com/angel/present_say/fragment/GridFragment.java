package com.angel.present_say.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.activity.HotItemActivity;
import com.angel.present_say.adapter.HotItemAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.GridCom;
import com.angel.present_say.bean.HotGrid;
import com.angel.present_say.common.HotConstant;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/3/15.
 */
@ContentView(R.layout.fragment_grid)
public class GridFragment extends BaseFragment {

    @ViewInject(R.id.gridview_fragment_hot)
    private GridView mGridView;   //GridView

    private HotItemAdapter mAdapter; //适配器

    private ArrayList<HotGrid.HotDataEntity.HotItems.HotData> mHotList = new ArrayList<>(); //数据源

    private ArrayList<GridCom.DataEntity.ItemsEntity> mItemList = new ArrayList<>();

    private String mKeyword;

    public static GridFragment newInstance(String keyword) {

        Bundle args = new Bundle();

        args.putString("mKeyword", keyword);

        GridFragment fragment = new GridFragment();

        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void requestNetData() {

        if (getArguments() != null) {
            mKeyword = getArguments().getString("mKeyword");

            if (TextUtils.isEmpty(mKeyword)) {

                xHttpUtils.get(HotConstant.HOT_URL, this);

            } else {

                //http://api.liwushuo.com/v2/search/item?limit=20&offset=0&sort=&keyword=%E9%9B%B6%E9%A3%9F

                Log.i("ssss", "requestNetData: " + mKeyword);

                xHttpUtils.get("http://api.liwushuo.com/v2/search/item?limit=20&offset=0&sort=&keyword=" + mKeyword, this);
            }
        }

    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {
        if (TextUtils.isEmpty(mKeyword)) {
            mAdapter = new HotItemAdapter(getActivity(), mHotList);
        }else {
            mAdapter = new HotItemAdapter(getActivity(),mItemList,true);
        }

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

        Log.i("ssss", "get: "+TextUtils.isEmpty(mKeyword));

        if (TextUtils.isEmpty(mKeyword)) {

            HotGrid hotGrid = JSONObject.parseObject(result, HotGrid.class);

            if (hotGrid != null) {

                List<HotGrid.HotDataEntity.HotItems> hotItemsList = hotGrid.getData().getItems();

                for (HotGrid.HotDataEntity.HotItems items : hotItemsList) {
                    mHotList.add(items.getData());
                }
                mAdapter.notifyDataSetChanged();
            }
        } else {

            GridCom gridCom = JSONObject.parseObject(result, GridCom.class);

            Log.i("ssss", "get: "+ gridCom);
            if (gridCom != null) {

                mItemList.addAll(gridCom.getData().getItems());


                mAdapter.notifyDataSetChanged();
            }

        }
    }
}