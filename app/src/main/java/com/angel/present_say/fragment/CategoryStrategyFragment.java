package com.angel.present_say.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.angel.present_say.R;
import com.angel.present_say.adapter.CategoryStrategyListAdapter;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.bean.CategoryList;
import com.angel.present_say.common.CategoryConstant;
import com.angel.present_say.receiver.BluetoothReceiver;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
@ContentView(R.layout.fragment_strategy_category)
public class CategoryStrategyFragment extends BaseFragment {

    private BluetoothAdapter bluetoothAdapter;  //本地蓝牙

    private BluetoothDevice device;  //可以连接设备

    private BluetoothReceiver receiver = new BluetoothReceiver();

    private CategoryStrategyListAdapter mAdapter;

    @ViewInject(R.id.listview_strategy_category)
    private ListView mListView;

    private List<CategoryList.CategoryDataEntity.CategoryChannelGroups> list = new ArrayList<>();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //蓝牙操作
    //    setMyBluetooth();
    }

    @Override
    public void requestNetData() {

        xHttpUtils.get(CategoryConstant.LIST_GET_URL, this);

    }

    @Override
    public void initData() {
        //加载布局
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_header_strategy, null);
        mListView.addHeaderView(view);
    }

    @Override
    public void setAdapter() {
        mAdapter = new CategoryStrategyListAdapter(getActivity(), list);

        mListView.setAdapter(mAdapter);
    }

    /**
     * 蓝牙操作
     */
    private void setMyBluetooth() {
//        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        if (bluetoothAdapter == null) {
//            //本地没有蓝牙设备
//            getActivity().finish();
//        }
//
//        if (bluetoothAdapter.isEnabled()) {
//            bluetoothAdapter.enable(); //打开蓝牙设备
//
//            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(intent,222);
//        }
    }

    private void setDiscoveryTime() {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

        //120s~300s
        intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 500);
        startActivity(intent);

    }

    private void scanBluetoothDevice() {
        //开始扫描

        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        getActivity().registerReceiver(receiver, intentFilter);
        bluetoothAdapter.startDiscovery();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (receiver != null) {
//            getActivity().unregisterReceiver(receiver);
//        }
//        bluetoothAdapter.cancelDiscovery();
    }

    @Override
    public void get(String result) {
        CategoryList.CategoryDataEntity data = JSONObject.parseObject(result, CategoryList.class).getData();
        if (data != null) {
            list.addAll(data.getChannel_groups());
            mAdapter.notifyDataSetChanged();
        }
    }
}