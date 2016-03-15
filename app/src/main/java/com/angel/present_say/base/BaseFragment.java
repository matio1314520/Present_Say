package com.angel.present_say.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.angel.present_say.utils.xHttpUtils;

import org.xutils.x;

/**
 * Created by Angel on 2016/1/29.
 */
public abstract class BaseFragment extends Fragment implements xHttpUtils.Callback {

    private OnFragmentInteractionListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requestNetData();


        initData();


        setAdapter();
    }

    /**
     * 请求网络
     */
    public abstract void requestNetData();

    /**
     * 初始化
     */
    public abstract void initData();

    /**
     * 设置适配器
     */
    public abstract void setAdapter();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(String url);
    }

    public OnFragmentInteractionListener getmListener() {
        return mListener;
    }
}