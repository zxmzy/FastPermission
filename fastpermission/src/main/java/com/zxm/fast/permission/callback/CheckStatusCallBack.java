package com.zxm.fast.permission.callback;

import android.app.Activity;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public interface CheckStatusCallBack {
    /**
     * 状态OK
     *
     * @param activity 状态可用的回调
     */
    void onStatusOk(Activity activity);

    /**
     * 状态错误
     */
    void onStatusError();
}
