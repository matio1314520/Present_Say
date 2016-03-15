package com.angel.present_say.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.angel.present_say.R;
import com.angel.present_say.base.AppBaseAdapter;
import com.angel.present_say.bean.CategoryList;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
public class CategoryRightAdapter extends AppBaseAdapter {

    public CategoryRightAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        CategoryViewHoler viewHoler = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listivew_category, parent, false);
            viewHoler = new CategoryViewHoler(convertView);
            convertView.setTag(viewHoler);
        } else {
            viewHoler = (CategoryViewHoler) convertView.getTag();
        }
        CategoryList.CategoryDataEntity.CategoryChannelGroups groups = (CategoryList.CategoryDataEntity.CategoryChannelGroups) mList.get(position);
        if (groups != null) {
            viewHoler.nameTxt.setText(groups.getName());
        }

        CategoryGridAdapter adapter = new CategoryGridAdapter(mContext, groups.getChannels());
        viewHoler.contentGrid.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return convertView;
    }

    /**
     *
     */
    class CategoryViewHoler {

        @ViewInject(R.id.allname_listview_category)
        public TextView nameTxt;

        @ViewInject(R.id.gridview_category)
        public GridView contentGrid;

        public CategoryViewHoler(View view) {
            x.view().inject(this, view);
        }
    }
}
