package com.angel.present_say.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseActivity;
import com.angel.present_say.base.BaseFragment;
import com.angel.present_say.fragment.CategoryFragment;
import com.angel.present_say.fragment.GuideFragment;
import com.angel.present_say.fragment.HotFragment;
import com.angel.present_say.fragment.MineFragment;
import com.angel.present_say.utils.FragmentUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Angel on 2016/1/30.
 */
@ContentView(R.layout.activity_home)
public class HomeActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    @ViewInject(R.id.choose_home)
    private RadioGroup whichRag;

    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentList.add(GuideFragment.newInstance());
        fragmentList.add(HotFragment.newInstance());
        fragmentList.add(CategoryFragment.newInstance());
        fragmentList.add(MineFragment.newInstance());

        new FragmentUtils(getSupportFragmentManager(), fragmentList, R.id.container_activity_home, whichRag);
    }

    @Override
    public void onFragmentInteraction(String url) {

    }
}
