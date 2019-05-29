package com.zxm.fast.permission.checker;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationManagerCompat;

import com.zxm.easypermission.bean.Special;
import com.zxm.easypermission.debug.PermissionDebug;


/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public class SpecialChecker implements PermissionChecker {
    private static final String TAG = SpecialChecker.class.getSimpleName();

    private Context context;

    private Special permission;

    public SpecialChecker(Context context, Special permission) {
        this.context = context;
        this.permission = permission;
    }

    @Override
    public boolean check() {
        try {
            switch (permission) {
                case NOTIFICATION:
                    return checkNotification();
                case SYSTEM_ALERT:
                    return checkSystemAlert();
                case UNKNOWN_APP_SOURCES:
                    return checkUnknownSource();
                default:
                    return true;
            }
        } catch (Exception e) {
            PermissionDebug.w(TAG, e.toString());
        }
        return true;
    }

    private boolean checkNotification() {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    private boolean checkSystemAlert() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return Settings.canDrawOverlays(context);
        }
        return new AppOpsChecker(context).checkOp(24);
    }

    private boolean checkUnknownSource() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return context.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }
}
