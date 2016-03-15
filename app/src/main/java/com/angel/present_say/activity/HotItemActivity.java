package com.angel.present_say.activity;

import android.os.Bundle;
import android.view.View;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseActivity;
import com.angel.present_say.common.HotConstant;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

/**
 * Created by Angel on 2016/2/19.
 */
@ContentView(R.layout.activity_hotdetail)
public class HotItemActivity extends BaseActivity implements xHttpUtils.Callback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestNetData();


        initData();


        setAdapter();
    }

    /**
     * 请求网络
     */
    private void requestNetData() {
        xHttpUtils.get(getUrl(), this);

    }

    /**
     * 获取传值
     *
     * @return
     */
    private String getUrl() {


        if (getIntent() != null) {

            int id = getIntent().getIntExtra("id", 0);

            return HotConstant.HEADER_GET_URL + id;
        }

        return null;
    }

    /**
     * 初始化
     */
    private void initData() {


    }

    /**
     * 设置适配器
     */
    public void setAdapter() {


    }


    @Event(value = {R.id.back_activity_hotdetail, R.id.share_activity_hotdetail, R.id.favorite_activity_hotdetail, R.id.buy_activity_hotdetail})
    private void onClick(View view) {
        switch (view.getId()) {

            case R.id.back_activity_hotdetail:
                finish();
                break;

            case R.id.share_activity_hotdetail:

                share();
                break;


            case R.id.favorite_activity_hotdetail:
                break;


            case R.id.buy_activity_hotdetail:
                break;
        }
    }

    /**
     * 一键分享
     */
    private void share() {


    }

    @Override
    public void get(String result) {

    }
}
