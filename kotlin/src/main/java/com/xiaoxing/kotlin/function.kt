package com.xiaoxing.kotlin

import android.util.Log
import android.view.View

/**

 *@Description: 描述

 *@Author: qushaohua

 *@CreateDate: 2022/1/17 2:17 下午

 */
class function {

    companion object{

        /**
         * 无参数，无返回值高阶函数
         */
        fun test1(msg: () -> Unit){
            Log.d("print","无参数，无返回值高阶函数")
        }

        /**
         * 无参数，有返回值高阶函数
         */
        fun test2(msg: () -> String){
            Log.d("print", "有返回值${msg()}")
        }

        /**
         * 有参数，无返回值高阶函数
         */
        fun test3(msg: (Int) -> Unit){
            Log.d("print", "有返回值无返回值${msg(99)}")
        }

        /**
         * 有参数，无返回值高阶函数
         */
        fun test4(msg: (str : String) -> Unit){
            Log.d("print", "有返回值无返回值${msg("哈哈哈")}")
        }

        /**
         * 有参数，有返回值高阶函数
         */
        fun test5(msg: (str : String) -> String){
            Log.d("print", "有返回值无返回值${msg("哈哈哈")}")
        }

        /**
         * 多个参数，有返回值高阶函数
         */
        fun test6(msg: (Int,String) -> String){
            Log.d("print", "有返回值无返回值${msg.invoke(2,"哈哈哈")}")
        }
        /**
         * 多参数，有返回值高阶函数
         */
        fun test7(msg: (Int,String) -> String, msg1: (String,String) -> String){
            Log.d("print", "有返回值无返回值${msg.invoke(2,"哈哈哈")}")
        }
    }

    public fun sum(a : Int, b : Int) = a+b

}