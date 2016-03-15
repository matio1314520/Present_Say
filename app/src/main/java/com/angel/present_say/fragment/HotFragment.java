package com.angel.present_say.fragment;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseFragment;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Angel on 2016/1/29.
 */
@ContentView(R.layout.fragment_hot)
public class HotFragment extends BaseFragment {


    public static HotFragment newInstance() {

        HotFragment fragment = new HotFragment();
        return fragment;
    }


    @Override
    public void requestNetData() {


    }

    @Override
    public void initData() {

        getChildFragmentManager().beginTransaction().add(R.id.container_fragment_hot,GridFragment.newInstance(null)).commit();

    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void get(String result) {


    }
}
