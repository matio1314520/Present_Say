package com.angel.present_say.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Angel on 2016/1/30.
 */
@ContentView(R.layout.activity_choose_sex)
public class ChooseActivity extends BaseActivity implements View.OnClickListener {

    @ViewInject(R.id.sex_rag_choose)
    private RadioGroup sexRag;    //单选按钮

    @ViewInject(R.id.priority_choose_sex)
    private LinearLayout priorityLin;

    @ViewInject(R.id.back_choose_sex)
    private ImageView backImg;

    @ViewInject(R.id.sex_priority_chooose)
    private TextView sexPriTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化
        x.view().inject(this);

        //设置RadioGroup的点击事件
        setRadioGroupListener();

        //设置点击事件
        setClickListener();
    }

    /**
     * 设置点击事件
     */
    private void setClickListener() {
        backImg.setOnClickListener(this);
        priorityLin.setOnClickListener(this);
    }

    /**
     * 设置RadioGroup的点击事件
     */
    private void setRadioGroupListener() {
        sexRag.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.boy_sex_choose) {

                } else if (checkedId == R.id.gril_sex_choose) {

                }
                group.setVisibility(View.GONE);
                backImg.setVisibility(View.VISIBLE);
                sexPriTxt.setText("请选择您的身份");
                priorityLin.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_choose_sex:

                priorityLin.setVisibility(View.GONE);
                sexPriTxt.setText("请选择您的性别");
                backImg.setVisibility(View.GONE);
                sexRag.setVisibility(View.VISIBLE);

                break;

            case R.id.priority_choose_sex:
                for (int i = 0, count = priorityLin.getChildCount(); i < count; i++) {
                    RelativeLayout priorityRel = (RelativeLayout) priorityLin.getChildAt(i);

                }

                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
