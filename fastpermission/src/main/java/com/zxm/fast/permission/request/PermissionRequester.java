package com.zxm.fast.permission.request;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;

import com.zxm.fast.permission.bean.Permission;
import com.zxm.fast.permission.bean.Special;
import com.zxm.fast.permission.callback.RequestPermissionListener;
import com.zxm.fast.permission.callback.SpecialPermissionListener;
import com.zxm.fast.permission.request.fragment.FragmentProxy;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description 运行时权限请求者
 */
public class PermissionRequester {
    private FragmentProxy permissionFragment;

    private String[] permissions;

    private Special permissionSpecial;

    public PermissionRequester(Activity activity) {
        this.permissionFragment = new FragmentProxy(PermissionFragmentFactory.create(activity));
    }

    /**
     * 权限名称
     *
     * @param permissionNames 如 Manifest.permission.CAMERA
     */
    public PermissionRequester withPermission(String... permissionNames) {
        this.permissions = permissionNames;
        return this;
    }

    /**
     * 包含权限的实体类
     */
    public PermissionRequester withPermission(Permission... permissions) {
        this.permissions = new String[permissions.length];
        for (int i = 0, size = permissions.length; i < size; i++) {
            this.permissions[i] = permissions[i].permissionName;
        }
        return this;
    }

    /**
     * 特殊权限
     *
     * @param permissionSpecial 特殊权限
     *                          {@link Special }
     */
    public PermissionRequester withPermission(Special permissionSpecial) {
        this.permissionSpecial = permissionSpecial;
        return this;
    }

    /**
     * 请求运行时权限
     */
    @TargetApi(Build.VERSION_CODES.M)
    public void request(RequestPermissionListener listener) {
        if (permissionFragment == null || permissions == null) {
            throw new IllegalArgumentException("fragment or params permission is null");
        }
        permissionFragment.requestPermissions(permissions, listener);
    }

    /**
     * 请求特殊权限
     */
    public void request(SpecialPermissionListener listener) {
        if (permissionFragment == null || permissionSpecial == null) {
            throw new IllegalArgumentException("fragment or params special permission is null");
        }
        permissionFragment.requestSpecialPermission(permissionSpecial, listener);
    }
}
