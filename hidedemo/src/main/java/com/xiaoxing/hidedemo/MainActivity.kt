package com.xiaoxing.hidedemo

import android.graphics.PixelFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.webkit.WebView
import com.xiaoxing.hidedemo.R
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import android.webkit.WebSettings
import android.widget.ImageView
import android.widget.LinearLayout


@Route(path = "/test/main")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_main)
        val tvTitle = findViewById<TextView>(R.id.tv_title)
        if (intent != null && intent.getStringExtra("key") != null) {
            tvTitle.text = intent.getStringExtra("key")
        }
//        var webView = findViewById<WebView>(R.id.mWebView)
//        webView.loadUrl("https://blog.csdn.net/qq_37475168/article/details/121306077")
        MaskWindowView(this,"https://www.baidu.com/")
    }

}