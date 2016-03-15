package com.angel.present_say.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseActivity;
import com.angel.present_say.utils.ViewPagerUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

@ContentView(R.layout.activity_guide)
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @ViewInject(R.id.guide_viewpager)
    private ViewPager guideVip;

    @ViewInject(R.id.guide_point)
    private LinearLayout pointLin;

    @ViewInject(R.id.guide_experience)
    private ImageView experienceImg;

    //viewPager数据源
    private ArrayList<View> imgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //初始化
        x.view().inject(this);

        //初始化ViewPager数据源
        initViewPagerData();

        //设置viewPager适配器
        setViewPagerAdapter();

        //viewpager监听事件
        setViewPagerListener();

        //设置点击监听
        setClickListener();

    }

    /**
     * 设置点击监听
     */
    private void setClickListener() {
        experienceImg.setOnClickListener(this);
    }

    /**
     * viewpager监听事件
     */
    private void setViewPagerListener() {
        guideVip.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //设置点
                setPointImg(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 设置点
     *
     * @param position 被选中的下标
     */
    private void setPointImg(int position) {
        for (int i = 0, count = pointLin.getChildCount(); i < count; i++) {
            ImageView currentImg = (ImageView) pointLin.getChildAt(i);
            if (i == position) {
                currentImg.setImageResource(R.mipmap.btn_check_disabled_nightmode);
            } else {
                currentImg.setImageResource(R.mipmap.btn_check_disabled);
            }
            if (position == count - 1) {
                experienceImg.setVisibility(View.VISIBLE);
                pointLin.setVisibility(View.GONE);
            } else {
                experienceImg.setVisibility(View.GONE);
                pointLin.setVisibility(View.VISIBLE);
            }
        }

    }

    /**
     * 设置viewPager适配器
     */
    private void setViewPagerAdapter() {
        ViewPagerUtils.setAdapter(guideVip, imgList);

    }

    /**
     * 初始化ViewPager数据源
     */
    private void initViewPagerData() {
        int[] pointImArr = {R.mipmap.walkthrough_1, R.mipmap.walkthrough_2, R.mipmap.walkthrough_3, R.mipmap.walkthrough_4};

        for (int pointImg : pointImArr) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(pointImg);
            imgList.add(imageView);
        }
    }


    @Override
    public void onClick(View v) {
        //跳转带页面
        Intent intent = new Intent(this,ChooseActivity.class);
        startActivity(intent);

    }
}