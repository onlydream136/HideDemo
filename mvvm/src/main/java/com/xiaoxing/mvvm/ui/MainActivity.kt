package com.xiaoxing.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.xiaoxing.mvvm.R
import com.xiaoxing.mvvm.UserInfo
import com.xiaoxing.mvvm.UserModel
import com.xiaoxing.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //绑定
        val data = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        var user = UserModel()
        user.name = "哈哈用户"
        user.password = "123456"
        user.save(object : SaveListener<String>(){

            override fun done(p0: String?, p1: BmobException?) {
                if (p1 == null){
                    Log.d("print","添加数据成功")
                }else{
                    Log.d("print","数据创建失败\n"+ p1.message)
                }
            }

        })
        var userInfo = UserInfo("hahahh");
        data.user = user
    }
}