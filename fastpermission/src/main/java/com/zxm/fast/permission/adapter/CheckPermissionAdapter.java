package com.zxm.fast.permission.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.zxm.fast.permission.FastPermission;
import com.zxm.fast.permission.bean.Permission;
import com.zxm.fast.permission.callback.CheckRequestPermissionListener;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public abstract class CheckPermissionAdapter implements CheckRequestPermissionListener {

    @Override
    public void onPermissionDenied(Permission permission) {
        //SoulPermission提供栈顶Activity
        Activity activity = FastPermission.getInstance().getTopActivity();
        if (null == activity) {
            return;
        }
        String permissionDesc = permission.getPermissionNameDesc();
        new AlertDialog.Builder(activity)
                .setTitle("提示")
                .setMessage(permissionDesc + "异常，请前往设置－>权限管理，打开" + permissionDesc + "。")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //去设置页
                        FastPermission.getInstance().goPermissionSettings();
                    }
                }).create().show();
    }
}
