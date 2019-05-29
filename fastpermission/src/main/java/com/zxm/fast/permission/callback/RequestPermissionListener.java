package com.zxm.fast.permission.callback;

import com.zxm.fast.permission.bean.Permission;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public interface RequestPermissionListener {
    /**
     * 得到权限检查结果
     *
     * @param permissions 封装权限的数组
     */
    void onPermissionResult(Permission[] permissions);

}
