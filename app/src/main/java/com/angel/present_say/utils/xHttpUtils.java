package com.angel.present_say.utils;

import android.widget.ImageView;

import com.angel.present_say.R;

import org.xutils.common.util.DensityUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * Created by Angel on 2016/2/12.
 */
public class xHttpUtils {

    public static void get(String urlPath, final Callback callback) {

        x.http().get(new RequestParams(urlPath), new org.xutils.common.Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    callback.get(result);
                } else {
                    LogUtil.i("onSuccess:" + null);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.i("onError:");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.i("onCancelled:");
            }

            @Override
            public void onFinished() {
                LogUtil.i("onFinished:");
            }
        });
    }

    public static void getImage(ImageView imageView, String urlPath) {
        ImageOptions options = new ImageOptions.Builder()
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .setRadius(DensityUtil.dip2px(5))  //圆角半径
                .setCrop(true)  // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .build();
        x.image().bind(imageView, urlPath, options);
    }

    /**
     * Created by Angel on 2016/2/12.
     */
    public interface Callback {
         void get(String result);
    }
}
