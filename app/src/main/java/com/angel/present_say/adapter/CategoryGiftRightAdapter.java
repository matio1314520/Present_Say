package com.angel.present_say.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.angel.present_say.R;
import com.angel.present_say.base.AppBaseAdapter;
import com.angel.present_say.bean.CategoryGift;
import com.angel.present_say.widget.CustomGridView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/2/15.
 */
public class CategoryGiftRightAdapter extends AppBaseAdapter {


    public CategoryGiftRightAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        CategoryViewHoler viewHoler = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_right_gift,
                    parent, false);
            viewHoler = new CategoryViewHoler(convertView);
            convertView.setTag(viewHoler);
        } else {
            viewHoler = (CategoryViewHoler) convertView.getTag();
        }
        CategoryGift.CategoryGiftData.CategoryGiftCategories categories = (CategoryGift.CategoryGiftData.CategoryGiftCategories) mList.get(position);
        if (categories != null) {
            viewHoler.nameTxt.setText(categories.getName());
        }

        CategoryGiftGridAdapter adapter = new CategoryGiftGridAdapter(mContext, categories.getSubcategories());
        viewHoler.contentGrid.setAdapter(adapter);

        return convertView;
    }

    /**
     *
     */
    class CategoryViewHoler {

        @ViewInject(R.id.name_item_right_gift)
        public TextView nameTxt;

        @ViewInject(R.id.gridview_item_right_gift)
        public CustomGridView contentGrid;

        public CategoryViewHoler(View view) {
            x.view().inject(this, view);
        }
    }
}
