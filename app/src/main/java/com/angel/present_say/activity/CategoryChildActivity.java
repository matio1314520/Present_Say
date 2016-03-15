package com.angel.present_say.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseActivity;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.fragment.GuideChildFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

/**
 * Created by Angel on 2016/3/13.
 */
@ContentView(R.layout.activity_categotychild)
public class CategoryChildActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

    }

    private void initData() {
        if (getIntent() != null) {
            int id = getIntent().getIntExtra("id", 0);

            Log.i("ssss", "initData: " + id);

            /***
             *
             *
             *
             *
             *
             *  CustomFragment.newInstance(id)
             *
             *
             *
             *
             */
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_activity_category_child, GuideChildFragment.newInstance(id,false,null))
                    .commit();
        }
    }

    @Event(value = {R.id.back_activity_categorychild, R.id.show_activity_categorychild})
    private void onClick(View view) {
        switch (view.getId()) {

            case R.id.back_activity_categorychild:
                finish();
                break;

            case R.id.show_activity_categorychild:
                break;
        }

    }

    @Override
    public void onFragmentInteraction(String url) {

    }
}
