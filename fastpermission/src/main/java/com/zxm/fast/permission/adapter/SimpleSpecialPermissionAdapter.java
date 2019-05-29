package com.zxm.fast.permission.adapter;

import com.zxm.fast.permission.bean.Special;
import com.zxm.fast.permission.callback.SpecialPermissionListener;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public abstract class SimpleSpecialPermissionAdapter implements SpecialPermissionListener {
    @Override
    public void onDenied(Special permission) {

    }

    @Override
    public void onGranted(Special permission) {

    }
}
