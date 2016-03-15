package com.angel.present_say.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/3/15.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    public Context mContext;

    public List<T> mList;

    public LayoutInflater mInflater;

    public int mLayoutId;

    public CommonAdapter(Context context, List<T> list, int layoutId) {

        this.mContext = context;

        this.mList = list;

        this.mLayoutId = layoutId;

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
        CommonVh vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
            convertView.setTag(vh);
        } else {
            vh = (CommonVh) convertView.getTag();
        }

        onBindViewHolder(vh,position);

        return convertView;
    }

    public abstract void onBindViewHolder(CommonVh holder, int position);


    public abstract class CommonVh {


        public CommonVh(View view) {

            x.view().inject(this, view);
        }
    }


}
