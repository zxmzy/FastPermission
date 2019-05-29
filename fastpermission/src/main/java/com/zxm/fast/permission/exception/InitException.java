package com.zxm.fast.permission.exception;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public class InitException extends IllegalStateException {

    public InitException() {
        super("auto init failed ,you need invoke EasyPermission.init() in your application");
    }
}