package com.angel.present_say.fragment;

import android.os.Bundle;

import com.angel.present_say.R;
import com.angel.present_say.base.BaseFragment;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Angel on 2016/3/15.
 */
@ContentView(R.layout.fragment_searchchild)
public class SearchChildFragment extends BaseFragment {

    public SearchChildFragment() {

    }

    public static SearchChildFragment newInstance(String content) {

        Bundle args = new Bundle();

        args.putString("content", content);

        SearchChildFragment fragment = new SearchChildFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void requestNetData() {
        if (getArguments() != null){

        }

    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void get(String result) {

    }
}
