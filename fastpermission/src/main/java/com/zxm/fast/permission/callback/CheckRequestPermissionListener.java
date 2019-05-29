package com.zxm.fast.permission.callback;

import com.zxm.easypermission.bean.Permission;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public interface CheckRequestPermissionListener {
    /**
     * 权限ok，可做后续的事情
     *
     * @param permission 权限实体类
     */
    void onPermissionOk(Permission permission);

    /**
     * 权限不ok，被拒绝或者未授予
     *
     * @param permission 权限实体类
     */
    void onPermissionDenied(Permission permission);
}
