package com.angel.present_say.utils;

import android.util.Log;

/**
 * Created by Angel on 2016/3/15.
 */
public class LogUtils {

    private static final boolean DEBUG = true;

    public static void log_d(Class clazz, String log) {

        if (DEBUG) {

            Log.d(clazz.toString(), log);

        }
    }
}
