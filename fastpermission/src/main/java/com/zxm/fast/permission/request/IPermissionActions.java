package com.zxm.fast.permission.request;

import android.annotation.TargetApi;
import android.os.Build;

import com.zxm.fast.permission.bean.Special;
import com.zxm.fast.permission.callback.RequestPermissionListener;
import com.zxm.fast.permission.callback.SpecialPermissionListener;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public interface IPermissionActions {
    /**
     * 请求权限
     *
     * @param permissions 权限
     * @param listener    回调
     */
    @TargetApi(Build.VERSION_CODES.M)
    void requestPermissions(String[] permissions, RequestPermissionListener listener);


    /**
     * 请求特殊权限
     *
     * @param permission 特殊权限
     * @param listener   回调
     */
    void requestSpecialPermission(Special permission, SpecialPermissionListener listener);
}
