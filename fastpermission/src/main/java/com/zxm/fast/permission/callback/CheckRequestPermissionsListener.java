package com.zxm.fast.permission.callback;

import com.zxm.easypermission.bean.Permission;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public interface CheckRequestPermissionsListener {
    /**
     * 所有权限ok，可做后续的事情
     *
     * @param allPermissions 权限实体类
     */
    void onAllPermissionOk(Permission[] allPermissions);

    /**
     * 不ok的权限，被拒绝或者未授予
     *
     * @param refusedPermissions 权限实体类
     */
    void onPermissionDenied(Permission[] refusedPermissions);
}
