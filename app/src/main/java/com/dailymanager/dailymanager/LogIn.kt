package com.dailymanager.dailymanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.coroutines.*

class LogIn : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewpager: ViewPager
    private lateinit var get_started_btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        viewpager = findViewById(R.id.vp_login_id)
        get_started_btn = findViewById(R.id.btn_getStarted_id)

        val viewpageAdapter = ViewPagerAdapter()
        viewpager.adapter = viewpageAdapter
        autoSlider(0)
        get_started_btn.setOnClickListener(this)
    }

    private fun autoSlider(i: Int) {
        var a = i + 1
        if (i == 3) {
            a = 0
        }
        GlobalScope.launch {
            delay(3000)
            withContext(Dispatchers.Main) {
                viewpager.apply {
                    currentItem = a
                    true
                }
                autoSlider(a++)
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_getStarted_id -> {
                startActivity(Intent(this@LogIn, MainActivity::class.java))
                finish()
            }

        }
    }
}