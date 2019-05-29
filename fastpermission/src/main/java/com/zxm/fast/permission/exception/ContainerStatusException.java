package com.zxm.fast.permission.exception;

/**
 * Created by zhangxiaoming.
 * Date: 2019/5/28
 * Description
 */
public class ContainerStatusException extends IllegalStateException {
    public ContainerStatusException() {
        super("activity did not existence, check your app status before use soulPermission");
    }
}
