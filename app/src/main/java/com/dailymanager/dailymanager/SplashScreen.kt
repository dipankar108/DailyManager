package com.dailymanager.dailymanager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val sharedPref = getSharedPreferences("opened", Context.MODE_PRIVATE)
        val value = sharedPref.getBoolean("isOpened", false)
        if (value) {
            GlobalScope.launch {
                delay(1000)
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                finish()
            }
        } else {
            GlobalScope.launch {
                delay(1000)
                startActivity(Intent(this@SplashScreen, LogIn::class.java))
                finish()
            }
            sharedPref.edit().putBoolean("isOpened", true).apply()
        }

    }
}