package com.xiaoxing.hide

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.xiaoxing.jsbridgelib.test.JsBridgeActivity
import com.yolanda.jsbridgelib.util.AppJsonUtils
import java.math.BigDecimal
import java.util.concurrent.*

class MainActivity : AppCompatActivity() {
    private var position = 0
    val threadPoolExecutor =
        ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS, LinkedBlockingQueue<Runnable>(6))
    val fixedThreadPool = Executors.newFixedThreadPool(2)
    val cacheThreadPool = Executors.newCachedThreadPool()
    val singleThreadExecutor = Executors.newSingleThreadExecutor()
    val scheduledThreadPool: ExecutorService = Executors.newScheduledThreadPool(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JsBridgeActivity.ACCESSIBILITY_SERVICE
        val tv = findViewById<TextView>(R.id.tv_des)
        tv.movementMethod = ScrollingMovementMethod.getInstance() //可滚动
        findViewById<View>(R.id.btn1).setOnClickListener {
            position = 0
            setDefaultAlias()
        }
        findViewById<View>(R.id.btn2).setOnClickListener {
            position = 1
            setAlias()
        }
        findViewById<View>(R.id.btn3).setOnClickListener { v: View? ->
            val intent = Intent()
            val uri = Uri.parse("tyras://test.tyras.com/main")
            intent.data = uri
            startActivity(intent)
        }
        findViewById<View>(R.id.btn4).setOnClickListener {
            ARouter.getInstance().build("/test/main")
                .withString("key", "我是app壳调过来的")
                .navigation()
        }

        findViewById<View>(R.id.btn5).setOnClickListener{
            for (i in 1..10) {
                val command = Runnable {
                    try {
                        Thread.sleep(3000)
                        Log.e("print","当前线程个数：$i, 线程名：${Thread.currentThread().name}")
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                threadPoolExecutor.execute(command)
            }
        }

        Log.d("print",Utils.timeStamp2Date(null))
//
//
//
//
//        for (i in 1..30) {
//            val runnable = Runnable {
//                try {
//                    Thread.sleep(3000)
//                    Log.e("Thread++", i.toString())
//                    Log.e("当前线程++", Thread.currentThread().name)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//            threadPoolExecutor.execute(runnable)
////            threadPoolExecutor.execute(runnable)
//        }

        for (i in 1..10) {
            val command = Runnable {
                try {
                    Thread.sleep(3000)
                    Log.e("print","当前线程个数：$i, 线程名：${Thread.currentThread().name}")
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            threadPoolExecutor.execute(command)
        }
    }


    override fun onBackPressed() {
//        //根据具体业务需求设置切换条件,我公司采用接口控制icon切换
//        if (position == 0) {
//            setDefaultAlias();
//        } else {
//            setAlias();
//        }
        super.onBackPressed()
    }

    override fun onDestroy() {
        // 移除app前后台监听
//        ForegroundCallbacks.get(this).removeListener(this);
        super.onDestroy()
    }

    /**
     * 设置默认默认图标
     */
    fun setDefaultAlias() {
        val packageManager = packageManager
        val name1 = ComponentName(this, "com.xiaoxing.hide.DefaultAliasActivity")
        packageManager.setComponentEnabledSetting(
            name1,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        val name2 = ComponentName(this, "com.xiaoxing.hide.AliasActivity")
        packageManager.setComponentEnabledSetting(
            name2,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    /**
     * 设置活动主题图标
     */
    fun setAlias() {
        val packageManager = packageManager
        val name1 = ComponentName(this, "com.xiaoxing.hide.DefaultAliasActivity")
        packageManager.setComponentEnabledSetting(
            name1,
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
        val name2 = ComponentName(this, "com.xiaoxing.hide.AliasActivity")
        packageManager.setComponentEnabledSetting(
            name2,
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    companion object {
        /**
         * 由于四舍五入的数据，如果获取的数据为58.000，它的需要显示小数点的位数为2为或者3位；
         * 而double类型的数据，会自动将无效的0去掉，获取的值一直是58.0
         * 所以返回的数据只能是字符串
         */
        fun getPrecisionShow(d: Double, scale: Int): String {
            var d = d
            d = getFormat(d, scale)
            return String.format("%." + scale + "f", d).replace(",", ".")
        }

        /**
         * 获取double类型数据指定有效值后，四舍五入
         *
         * @param f     需要格式化的值
         * @param scale 需要格式化的小数点之后的位数
         */
        @SuppressLint("DefaultLocale")
        fun getFormat(f: Double, scale: Int): Double {
            val value: Double
            value = try {
                BigDecimal(f.toString()).setScale(scale, BigDecimal.ROUND_HALF_UP).toDouble()
            } catch (e: NumberFormatException) {
                0.0
            }
            return value
        }
    }
}