package com.angel.present_say.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.angel.present_say.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/3/14.
 */
public class GuideRecyAdapter extends RecyclerView.Adapter<GuideRecyAdapter.Vh> {

    private Context context;

    private List<String> list;

    public GuideRecyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Vh(LayoutInflater.from(context).inflate(R.layout.item_recycler_guide_header, parent, false));
    }

    @Override
    public void onBindViewHolder(Vh holder, int position) {

        x.image().bind(holder.iconView, list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Vh extends RecyclerView.ViewHolder {

        @ViewInject(R.id.icon_item_recycler_guide_header)
        public ImageView iconView;


        public Vh(View itemView) {
            super(itemView);
            x.view().inject(this, itemView);
        }
    }
}
