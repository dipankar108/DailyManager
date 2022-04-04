package com.dailymanager.dailymanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class LogIn : AppCompatActivity() {
    private lateinit var viewpager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        viewpager = findViewById(R.id.vp_login_id)
        val viewpageAdapter = ViewPagerAdapter()
        viewpager.adapter = viewpageAdapter
    }
}