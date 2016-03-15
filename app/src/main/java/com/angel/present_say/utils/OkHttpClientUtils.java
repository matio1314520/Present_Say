package com.angel.present_say.utils;

import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Angel on 2016/2/12.
 */
public class OkHttpClientUtils {

    public static void get(String urlPath, final xHttpUtils.Callback callback) {

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .get()
                .url(urlPath)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.i("matio", "request data failure");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response != null) {
                    callback.get(response.body().string());
                }
            }
        });
    }

}

