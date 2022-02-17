package com.xiaoxing.hide

import android.annotation.SuppressLint
import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * @Description: 描述
 * @Author: qushaohua
 * @CreateDate: 2022/1/24 3:34 下午
 */
object Utils {
    /**
     * 时间戳转换成日期格式字符串
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    fun timeStamp2Date(format: String?): String {
        var format = format
        val date = Date(System.currentTimeMillis())
        if (format == null || format.isEmpty()) {
            format = "ММ/dd"
//            format = "MM/dd"
        }
        val systime = Locale("bg", "BG")
        val sdf = SimpleDateFormat(format, systime)
        return sdf.format(date)
    }
}