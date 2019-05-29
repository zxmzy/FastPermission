package com.zxm.fast.permission.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.zxm.easypermission.EasyPermission;
import com.zxm.easypermission.bean.Permission;
import com.zxm.easypermission.callback.CheckRequestPermissionListener;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public abstract class CheckPermissionWithRationaleAdapter implements CheckRequestPermissionListener {
    private String rationaleMessage;

    private Runnable retryRunnable;

    /**
     * @param rationaleMessage 当用户首次拒绝弹框时候，根据权限不同给用户不同的文案解释
     * @param retryRunnable    用户点重新授权的runnable 即重新执行原方法
     */
    public CheckPermissionWithRationaleAdapter(String rationaleMessage, Runnable retryRunnable) {
        this.rationaleMessage = rationaleMessage;
        this.retryRunnable = retryRunnable;
    }

    @Override
    public void onPermissionDenied(Permission permission) {
        Activity activity = EasyPermission.getInstance().getTopActivity();
        if (null == activity) {
            return;
        }
        //绿色框中的流程
        //用户第一次拒绝了权限、并且没有勾选"不再提示"这个值为true，此时告诉用户为什么需要这个权限。
        if (permission.shouldRationale()) {
            new AlertDialog.Builder(activity)
                    .setTitle("提示")
                    .setMessage(rationaleMessage)
                    .setNegativeButton("不授予", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("授予", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //用户确定以后，重新执行请求原始流程
                            retryRunnable.run();
                        }
                    }).create().show();
        } else {
            //此时请求权限会直接报未授予，需要用户手动去权限设置页，所以弹框引导用户跳转去设置页
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
                            EasyPermission.getInstance().goPermissionSettings();
                        }
                    }).create().show();
        }
    }
}
