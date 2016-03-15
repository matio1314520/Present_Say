package com.angel.present_say.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.angel.present_say.R;
import com.angel.present_say.base.AppBaseAdapter;
import com.angel.present_say.bean.GuideList;
import com.angel.present_say.bean.SearchList;
import com.angel.present_say.utils.xHttpUtils;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/2/6.
 */
public class GuideItemAdapter extends AppBaseAdapter {

    private boolean mYes;

    public GuideItemAdapter(Context context, List list) {
        super(context, list);
        this.mList = list;
    }

    public GuideItemAdapter(Context context, List list, boolean yes) {
        this(context, list);
        this.mYes = yes;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_listview_guide, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (mYes) {
            SearchList.DataEntity.PostsEntity post = (SearchList.DataEntity.PostsEntity) mList.get(position);
            if (post != null) {

                x.image().bind(viewHolder.contentImg, post.getCover_image_url());
                viewHolder.likeTxt.setText("" + post.getLikes_count());
                viewHolder.titleTxt.setText(post.getTitle());
            }

        } else {
            GuideList.GuideListData.GuideListItems guideListItems = (GuideList.GuideListData.GuideListItems) mList.get(position);
            if (guideListItems != null) {

                if (position != 0 && guideListItems.getCreated_at() == ((GuideList.GuideListData.GuideListItems) mList.get(position - 1)).getCreated_at()) {
                    viewHolder.headerRel.setVisibility(View.GONE);
                } else {
                    viewHolder.dateTxt.setText("" + guideListItems.getCreated_at());
                }
                viewHolder.titleTxt.setText(guideListItems.getTitle());
                viewHolder.likeTxt.setText("" + guideListItems.getLikes_count());
                xHttpUtils.getImage(viewHolder.contentImg, guideListItems.getCover_image_url());
            }
        }

        return convertView;
    }

    /**
     *
     */
    class ViewHolder {

        @ViewInject(R.id.date_item_guide)
        public TextView dateTxt;

        @ViewInject(R.id.img_item_guide)
        public ImageView contentImg;

        @ViewInject(R.id.title_item_guide)
        public TextView titleTxt;

        @ViewInject(R.id.love_item_guide)
        public TextView likeTxt;

        @ViewInject(R.id.item_type_guide)
        public RelativeLayout headerRel;

        public ViewHolder(View convertView) {
            x.view().inject(this, convertView);
        }
    }
}
