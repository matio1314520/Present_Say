package com.angel.present_say.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Angel on 2016/1/29.
 */
public abstract class AppBaseAdapter<T> extends BaseAdapter {

    public Context mContext;

    public List<T> mList;

    public LayoutInflater mInflater;

    public AppBaseAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mList != null ? mList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position, convertView, parent);
    }

    public abstract View getItemView(int position, View convertView, ViewGroup parent);
}
