package com.zxm.fast.permission.request.fragment;

import android.support.annotation.NonNull;

import com.zxm.fast.permission.bean.Special;
import com.zxm.fast.permission.callback.RequestPermissionListener;
import com.zxm.fast.permission.callback.SpecialPermissionListener;
import com.zxm.fast.permission.debug.PermissionDebug;
import com.zxm.fast.permission.request.IPermissionActions;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public class FragmentProxy implements IPermissionActions {

    private static final String TAG = FragmentProxy.class.getSimpleName();

    private IPermissionActions fragmentImp;

    public FragmentProxy(IPermissionActions fragmentImp) {
        this.fragmentImp = fragmentImp;
    }

    @Override
    public void requestPermissions(@NonNull String[] permissions, RequestPermissionListener listener) {
        this.fragmentImp.requestPermissions(permissions, listener);
        PermissionDebug.d(TAG, fragmentImp.getClass().getSimpleName() + " request:" + hashCode());
    }

    @Override
    public void requestSpecialPermission(Special permission, SpecialPermissionListener listener) {
        this.fragmentImp.requestSpecialPermission(permission, listener);
        PermissionDebug.d(TAG, fragmentImp.getClass().getSimpleName() + " requestSpecial:" + hashCode());
    }
}
