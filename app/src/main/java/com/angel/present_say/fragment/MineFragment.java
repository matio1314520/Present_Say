package com.angel.present_say.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.angel.present_say.R;
import com.angel.present_say.activity.LoginActivity;
import com.angel.present_say.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Angel on 2016/1/29.
 */
@ContentView(R.layout.fragment_mine)
public class MineFragment extends BaseFragment {

    @ViewInject(R.id.gift_img_mine)
    private ImageView giftImg;

    @ViewInject(R.id.strategy_img_mine)
    private ImageView strategyImg;

    @ViewInject(R.id.content_mine)
    private TextView contentTxt;

    @ViewInject(R.id.personal_fragment_mine)
    private ImageView iconImg;

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //设置图片及文字
        setTextAndImg();

//        //设置监听事件
//        setMyClickListener();
    }

    @Override
    public void requestNetData() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {

    }

//    /**
//     * 设置监听事件
//     */
//    private void setMyClickListener() {
//        giftImg.setOnClickListener(this);
//        strategyImg.setOnClickListener(this);
//        iconImg.setOnClickListener(this);
//    }

//    /**
//     * 点击事件
//     *
//     * @param v
//     */
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.gift_img_mine:
//                setTextAndImg();
//                break;
//            case R.id.strategy_img_mine:
//                contentTxt.setText("喜欢的攻略放在这里哦");
//                strategyImg.setVisibility(View.VISIBLE);
//                giftImg.setVisibility(View.INVISIBLE);
//                break;
//            case R.id.personal_fragment_mine:
//                toAnotherPage();
//                break;
//        }
//    }

    @Event(value = {R.id.gift_img_mine, R.id.strategy_img_mine, R.id.personal_fragment_mine, R.id.scan_fragment_mine} )
    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.gift_img_mine:
                setTextAndImg();
                break;
            case R.id.strategy_img_mine:
                contentTxt.setText("喜欢的攻略放在这里哦");
                strategyImg.setVisibility(View.VISIBLE);
                giftImg.setVisibility(View.INVISIBLE);
                break;
            case R.id.personal_fragment_mine:
                toAnotherPage();
                break;
            case R.id.scan_fragment_mine:
                scan();
                break;
        }
    }

    /**
     * 扫描二维码
     */
    private void scan() {

    }


    /**
     * 页面跳转
     */
    private void toAnotherPage() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    /**
     * 设置图片及文字
     */
    private void setTextAndImg() {
        contentTxt.setText("喜欢的礼物放在这里哦");
        giftImg.setVisibility(View.VISIBLE);
        strategyImg.setVisibility(View.INVISIBLE);
    }

    @Override
    public void get(String result) {

    }
}