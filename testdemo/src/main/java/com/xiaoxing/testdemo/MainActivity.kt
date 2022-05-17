package com.xiaoxing.testdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.autofill.AutofillManager
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var view: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view = findViewById<LottieAnimationView>(R.id.lottie_view)
        findViewById<TextView>(R.id.tv_button1).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_button2).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_button3).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_button1 -> {
                AutoFillActivity.actionStart(this,1)
            }
            R.id.tv_button2 -> {
                AutoFillActivity.actionStart(this,2)
            }
            R.id.tv_button3 -> {
                AutoFillActivity.actionStart(this,3)
            }
            R.id.tv_button -> {
                view.playAnimation()
            }

        }
    }
}