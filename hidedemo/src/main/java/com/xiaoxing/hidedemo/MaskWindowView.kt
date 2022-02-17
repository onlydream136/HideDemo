package com.xiaoxing.hidedemo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.PixelFormat
import android.view.View
import android.view.WindowManager
import android.view.WindowManager.LayoutParams
import android.view.Gravity
import android.view.LayoutInflater
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.webkit.WebSettings

import android.webkit.WebChromeClient








/**

 *@Description: 遮罩弹窗webView
 *@Author: qushaohua
 *@CreateDate: 2022/1/20 10:31 上午

 */
class MaskWindowView(mActivity: Activity,val url : String) {
    var windowManager : WindowManager ?= null
    var view : View ?= null
    var context : Context = mActivity
    var webView : WebView?= null
    init {
        windowManager = mActivity.getSystemService(Context.WINDOW_SERVICE) as WindowManager?
        addView()
    }

    @SuppressLint("InflateParams")
    private fun addView(){
        view = LayoutInflater.from(context).inflate(R.layout.layout_webview_mask,null)
        var imageview = view?.findViewById<ImageView>(R.id.image)
        imageview?.setImageResource(R.drawable.test)
        webView = view?.findViewById(R.id.mWebView)

        webView?.loadUrl("https://www.baidu.com/")
//        val view = ImageView(context)
//        view.layoutParams =
//            LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT
//            )
//        view.setImageResource(R.drawable.ic_launcher_background)
//        view.loadUrl("https://www.baidu.com/")
        val params = LayoutParams()
        params.flags = LayoutParams.FLAG_NOT_FOCUSABLE or LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH or LayoutParams.FLAG_LAYOUT_NO_LIMITS
        params.format = PixelFormat.RGBA_8888; /*透明背景,否则会黑色*/
        params.width = LayoutParams.MATCH_PARENT
        params.height = LayoutParams.MATCH_PARENT
        params.gravity = Gravity.TOP
        windowManager?.addView(view,params)
    }

    fun setUrl(url : String){
//        val newUrl = if (TextUtils.isEmpty(url)) {
//            Api.getH5Url() + "Home.html"
//        } else {
//            if (url.startsWith("http") || url.startsWith("https")) {
//                //全路径不变
//                url
//            } else {
//                val userId = StorageRepositoryImpl.getStringValue(SystemConst.CURRENT_USERID, "")
//                if (url.contains("?")) {
//                    "${Api.getH5Url()}$url&user_id=$userId"
//                } else {
//                    "${Api.getH5Url()}$url?user_id=$userId"
//                }
//            }
//        }
        webView?.loadUrl(url)
    }
}