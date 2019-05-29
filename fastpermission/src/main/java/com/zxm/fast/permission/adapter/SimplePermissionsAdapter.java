package com.zxm.fast.permission.adapter;

import com.zxm.easypermission.bean.Permission;
import com.zxm.easypermission.callback.CheckRequestPermissionsListener;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public abstract class SimplePermissionsAdapter implements CheckRequestPermissionsListener {
    @Override
    public void onAllPermissionOk(Permission[] allPermissions) {

    }

    @Override
    public void onPermissionDenied(Permission[] refusedPermissions) {

    }
}
