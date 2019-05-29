package com.zxm.fast.permission.checker;

import android.content.Context;

import com.zxm.fast.permission.PermissionTools;
import com.zxm.fast.permission.bean.Special;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public class CheckerFactory {
    public static PermissionChecker create(Context context, Special permission) {
        return new SpecialChecker(context, permission);
    }

    public static PermissionChecker create(Context context, String permission) {
        if (PermissionTools.isOldPermissionSystem(context)) {
            return new AppOpsChecker(context, permission);
        } else {
            return new RunTimePermissionChecker(context, permission);
        }
    }
}
