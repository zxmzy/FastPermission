package com.zxm.fast.permission.callback;

import com.zxm.easypermission.bean.Special;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public interface SpecialPermissionListener {
    /**
     * 权限ok，可做后续的事情
     *
     * @param permission 权限实体类
     *                   {@link com.zxm.easypermission.bean.Special }
     */
    void onGranted(Special permission);

    /**
     * 权限不ok，被拒绝或者未授予
     *
     * @param permission 权限实体类
     */
    void onDenied(Special permission);

}
