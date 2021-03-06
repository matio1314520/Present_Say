package com.angel.present_say.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.angel.present_say.R;
import com.angel.present_say.base.AppBaseAdapter;
import com.angel.present_say.bean.CategoryGift;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
public class CategoryGiftGridAdapter extends AppBaseAdapter {


    public CategoryGiftGridAdapter(Context context, List list) {
        super(context, list);

    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_gridview_category, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CategoryGift.CategoryGiftData.CategoryGiftCategories.CategoryGiftSubcategories subcategories = (CategoryGift.CategoryGiftData.CategoryGiftCategories.CategoryGiftSubcategories) mList.get(position);

        viewHolder.nameTxt.setText(subcategories.getName());

        x.image().bind(viewHolder.iconImg, subcategories.getIcon_url());

        return convertView;
    }

    class ViewHolder {

        @ViewInject(R.id.icon_gridview_category)
        public ImageView iconImg;

        @ViewInject(R.id.name_gridview_category)
        public TextView nameTxt;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
