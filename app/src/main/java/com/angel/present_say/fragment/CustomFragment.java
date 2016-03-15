package com.angel.present_say.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.activity.StrategyDetailActivity;
import com.angel.present_say.adapter.GuideItemAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.GuideList;
import com.angel.present_say.common.CategoryConstant;
import com.angel.present_say.utils.xHttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/3/13.
 */
@ContentView(R.layout.fragment_custom)
public class CustomFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ListView>, xHttpUtils.Callback {

    @ViewInject(R.id.ptrlistview_fragment_custom)
    private PullToRefreshListView mPtrListview;

    private GuideItemAdapter mAdapter;

    private boolean mIsDownToRefresh = true; //是否下拉刷新

    private List<GuideList.GuideListData.GuideListItems> mList = new ArrayList();

    public static CustomFragment newInstance(int id) {

        Bundle args = new Bundle();

        args.putInt("id", id);

        CustomFragment fragment = new CustomFragment();

        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public void requestNetData() {
        if (getArguments() != null) {

            xHttpUtils.get(CategoryConstant.HEADER_URL_GET + getArguments().getInt("id") + CategoryConstant.FOOTER_URL_GET, this);
        }
    }

    @Override
    public void initData() {


    }

    @Override
    public void setAdapter() {
        mAdapter = new GuideItemAdapter(getActivity(), mList);

        mPtrListview.setMode(PullToRefreshBase.Mode.BOTH);

        mPtrListview.setOnRefreshListener(this);

        mPtrListview.setAdapter(mAdapter);
        //自动刷新,
        // ptrListView.setRefreshing();
    }

    @Override
    public void get(String result) {

        GuideList guideList = JSONObject.parseObject(result, GuideList.class);
        if (guideList != null) {

            mList.addAll(guideList.getData().getItems());

            mAdapter.notifyDataSetChanged();

            mPtrListview.onRefreshComplete();
        }

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

    @Event(value = R.id.ptrlistview_fragment_custom,type = AdapterView.OnItemClickListener.class)
    private void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getActivity(),StrategyDetailActivity.class);

        intent.putExtra("id",mList.get(position).getId());

        startActivity(intent);
    }
}
