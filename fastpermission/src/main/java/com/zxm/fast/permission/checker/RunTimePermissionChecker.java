package com.zxm.fast.permission.checker;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;


/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public class RunTimePermissionChecker implements PermissionChecker {
    private String permission;

    private Context context;

    RunTimePermissionChecker(Context context, String permission) {
        this.permission = permission;
        this.context = context;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public boolean check() {
        int checkResult = ContextCompat.checkSelfPermission(context, permission);
        return checkResult == PackageManager.PERMISSION_GRANTED;
    }
}
