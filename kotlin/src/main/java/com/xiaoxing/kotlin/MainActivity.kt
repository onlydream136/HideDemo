package com.xiaoxing.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        function.test1 {
            Log.d("print","test1")
        }
        function.test2 {
            Log.d("print","test2")
            "哈哈哈"
        }
        function.test3 {
            Log.d("print", "test3$it")
        }
        function.test4 {
            Log.d("print", "test4$it")
        }
        function.test5 {
            Log.d("print","test5$it")
            "hahahha"
        }
        function.test7(msg = {
            t,l ->
            Log.d("print","test7--->$t$l")
            "李四"
        }, msg1 = {
            g,h ->
            Log.d("print","test7--->$g$h")
            "张三"
        })
        val str = "28.00"

        Log.d("print","----------------->${str.toDouble()}")
    }
}