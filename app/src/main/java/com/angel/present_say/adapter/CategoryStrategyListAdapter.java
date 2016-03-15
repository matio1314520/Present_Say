package com.angel.present_say.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.angel.present_say.R;
import com.angel.present_say.activity.CategoryChildActivity;
import com.angel.present_say.base.AppBaseAdapter;
import com.angel.present_say.bean.CategoryList;
import com.angel.present_say.widget.CustomGridView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/2/13.
 * <p/>
 * 分类--》攻略---》listview适配器
 */
public class CategoryStrategyListAdapter extends AppBaseAdapter implements AdapterView.OnItemClickListener {


    private CategoryList.CategoryDataEntity.CategoryChannelGroups groups;

    public CategoryStrategyListAdapter(Context context, List list) {
        super(context, list);
        this.mList = list;
        this.mContext = context;
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

        groups = (CategoryList.CategoryDataEntity.CategoryChannelGroups) mList.get(position);
        if (groups != null) {
            viewHoler.nameTxt.setText(groups.getName());
        }

        CategoryGridAdapter adapter = new CategoryGridAdapter(mContext, groups.getChannels());

        viewHoler.contentGrid.setAdapter(adapter);

        viewHoler.contentGrid.setOnItemClickListener(this);

        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int subPosition, long id) {

        Intent intent = new Intent(mContext, CategoryChildActivity.class);

        intent.putExtra("id", groups.getChannels().get(subPosition).getId());

        mContext.startActivity(intent);
    }


    /**
     *
     */
    private class CategoryViewHoler {

        @ViewInject(R.id.allname_listview_category)
        public TextView nameTxt;

        @ViewInject(R.id.gridview_category)
        public CustomGridView contentGrid;

        public CategoryViewHoler(View view) {
            x.view().inject(this, view);
        }
    }
}
