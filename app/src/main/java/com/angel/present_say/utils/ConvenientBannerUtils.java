package com.angel.present_say.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.angel.present_say.R;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/3/12.
 */
public class ConvenientBannerUtils {


    public static void setBanner(ConvenientBanner banner, List<String> list) {

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new Vh();
            }
        }, list)
                .setPageIndicator(new int[]{R.mipmap.btn_check_disabled_nightmode, R.mipmap.btn_check_disabled})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

    }

    static class Vh implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {

            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            x.image().bind(imageView, data);
        }
    }
}
