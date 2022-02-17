package com.xiaoxing.hide

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Description: 描述
 * @Author: qushaohua
 * @CreateDate: 2022/1/12 11:41 上午
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}