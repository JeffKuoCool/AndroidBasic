package com.ztlj.common.manager;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @date: 2019-09-24
 * @autror: guojian
 * @description:
 */
public class RouterManager {
    public static void navigation(String routerPath) {
        ARouter.getInstance().build(routerPath).navigation();
    }
}
