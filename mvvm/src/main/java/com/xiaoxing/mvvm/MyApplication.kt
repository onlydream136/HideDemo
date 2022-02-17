package com.xiaoxing.mvvm

import android.app.Application
import cn.bmob.v3.Bmob

/**

 *@Description: 描述

 *@Author: qushaohua

 *@CreateDate: 2022/1/17 10:14 上午

 */
class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        Bmob.initialize(this,"88a97b8d66e41cb802095bba8c577da2")
    }

}