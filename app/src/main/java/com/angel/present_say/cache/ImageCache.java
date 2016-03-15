package com.angel.present_say.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;
import com.angel.present_say.App;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Angel on 2016/2/9.
 */
public class ImageCache implements ImageLoader.ImageCache {

    private static final int MAX_SIZE = (int) Runtime.getRuntime().maxMemory() / 8;

    private static ImageCache imageCache;

    private DiskCache diskCache; //磁盘缓存

    private LruCache<String, Bitmap> lruCache;  //内存缓存

    private ThreadPoolExecutor executor;   //线程池

    private LinkedBlockingQueue queue;

    /**
     * @return
     */
    public static ImageCache newInstance() {
        if (imageCache == null) {
            imageCache = new ImageCache();
        }
        return imageCache;
    }

    /**
     * 私有化构造器
     */
    private ImageCache() {

        diskCache = new DiskCache(App.getInstance());

        lruCache = new LruCache<String, Bitmap>(MAX_SIZE) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };

        queue = new LinkedBlockingQueue(20);
        executor = new ThreadPoolExecutor(2, 5, 500, TimeUnit.MILLISECONDS, queue);
    }

    @Override
    public Bitmap getBitmap(final String url) {
        Bitmap bitmap = null;
        if (url != null) {
            bitmap = lruCache.get(url);
            if (bitmap != null) {
                return bitmap;
            } else {
                //开线程
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap diskBitmap = diskCache.getBitmap(url);
                        if (diskBitmap != null) {
                            lruCache.put(url, diskBitmap);
                        } else {
                            //请求网络图片
                            getBitmapFromServer(url);
                        }
                    }
                });
            }
        }
        return bitmap;
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        if (diskCache.isFileExists(diskCache.getFileName(url))) {
            try {
                diskCache.savaBitmap(url, bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getBitmapFromServer(final String url) {
        Bitmap bitmap = null;
        x.http().get(new RequestParams(url), new Callback.CommonCallback<Bitmap>() {
            @Override
            public void onSuccess(Bitmap result) {
                if (result != null) {
                    lruCache.put(url, result);
                    try {
                        diskCache.savaBitmap(url, result);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
