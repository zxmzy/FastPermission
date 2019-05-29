package com.zxm.fast.permission.adapter;

import com.zxm.easypermission.bean.Permission;
import com.zxm.easypermission.callback.CheckRequestPermissionListener;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public abstract class SimplePermissionAdapter implements CheckRequestPermissionListener {
    @Override
    public void onPermissionOk(Permission permission) {

    }

    @Override
    public void onPermissionDenied(Permission permission) {

    }
}
