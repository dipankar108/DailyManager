package com.dailymanager.dailymanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var customFilterDialog: CustomFilterDialog
    private lateinit var ivFilter: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ivFilter = findViewById(R.id.iv_toolbar_filter_id)
        floatingActionButton = findViewById(R.id.fab_mainActivity_id)
        floatingActionButton.setOnClickListener(this)
        ivFilter.setOnClickListener(this)
        customFilterDialog = CustomFilterDialog()

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.fab_mainActivity_id -> {
                startActivity(Intent(this@MainActivity, CreateTask::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                })
            }
            R.id.iv_toolbar_filter_id -> {
                customFilterDialog.show(supportFragmentManager, "Dialog")
                customFilterDialog.isCancelable = true
            }
        }
    }
}