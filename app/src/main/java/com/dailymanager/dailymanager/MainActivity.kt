package com.dailymanager.dailymanager

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.dailymanager.dailymanager.bottomsheet.CreateTaskSheet
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener,FilterCallBack {
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
        customFilterDialog = CustomFilterDialog(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.fab_mainActivity_id -> {
                val bottomSheet = CreateTaskSheet()
                bottomSheet.show(supportFragmentManager, "None")
            }
            R.id.iv_toolbar_filter_id -> {
                customFilterDialog.show(supportFragmentManager, "Dialog")
                customFilterDialog.isCancelable = true
            }
        }
    }

    override fun selectedFilter(taskFilter: String) {
        Log.d("TAG", "selectedFilter: $taskFilter")
    }
}