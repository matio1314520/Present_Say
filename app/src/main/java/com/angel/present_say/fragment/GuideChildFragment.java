package com.angel.present_say.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.activity.StrategyDetailActivity;
import com.angel.present_say.adapter.GuideItemAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.GuideList;
import com.angel.present_say.common.GuideConstant;
import com.angel.present_say.utils.xHttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/2/18.
 */
@ContentView(R.layout.fragment_child_guide)
public class GuideChildFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ListView>, xHttpUtils.Callback {

    @ViewInject(R.id.ptrListview_fragment_childguide)
    private PullToRefreshListView mPtrListView;

    private List<GuideList.GuideListData.GuideListItems> mList = new ArrayList();

    private GuideItemAdapter mAdapter;

    private boolean mIsAddHeader;

    private boolean mIsDownToRefresh = true; //是否下拉刷新

    public static GuideChildFragment newInstance(int id, boolean isAddHeader) {

        Bundle args = new Bundle();

        args.putString("id", String.valueOf(id));

        args.putBoolean("isAddHeader", isAddHeader);

        GuideChildFragment fragment = new GuideChildFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void requestNetData() {

        if (getArguments() != null) {

            mIsAddHeader = getArguments().getBoolean("isAddHeader");

            xHttpUtils.get(GuideConstant.LIST_HEADER_URL +  getArguments().getString("id") + GuideConstant.LIST_LAST_URL, this);
        }
    }

    @Override
    public void initData() {
        if (mIsAddHeader) {
            //添加头部
        mPtrListView.getRefreshableView().addHeaderView(LayoutInflater.from(getActivity()).inflate(R.layout.container_guide_header, null));
        }
    }

    @Override
    public void setAdapter() {
        mAdapter = new GuideItemAdapter(getActivity(), mList);

        mPtrListView.setMode(PullToRefreshBase.Mode.BOTH);

        mPtrListView.setOnRefreshListener(this);

        mPtrListView.setAdapter(mAdapter);

        //自动刷新,
        // mPtrListView.setRefreshing();
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

        if (mIsDownToRefresh) {

            if (mList != null) {

                mList.clear();

            }

            requestNetData();

        }

        mIsDownToRefresh = true;
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

        mIsDownToRefresh = false;
    }

    @Override
    public void get(String result) {

        GuideList guideList = JSONObject.parseObject(result, GuideList.class);

        if (guideList != null) {

            mList.addAll(guideList.getData().getItems());

            mAdapter.notifyDataSetChanged();

            mPtrListView.onRefreshComplete();
        }
    }

    @Event(value = R.id.ptrListview_fragment_childguide, type = AdapterView.OnItemClickListener.class)
    private void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getActivity(), StrategyDetailActivity.class);

        intent.putExtra("url", mList.get(position).getUrl());

        startActivity(intent);
    }
}