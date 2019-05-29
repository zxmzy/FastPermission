package com.zxm.fast.permission.debug;

import android.util.Log;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public class PermissionDebug {
    private static boolean isDebug = false;

    public static void setDebug(boolean isDebug) {
        PermissionDebug.isDebug = isDebug;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }
}
