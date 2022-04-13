package com.dailymanager.dailymanager

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dailymanager.dailymanager.bottomsheet.CreateTaskSheet
import com.dailymanager.dailymanager.bottomsheet.CustomFilterDialog
import com.dailymanager.dailymanager.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener, FilterCallBack {
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var customFilterDialog: CustomFilterDialog
    private lateinit var ivFilter: ImageView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionbar = supportActionBar
        val drawableColor =
            ColorDrawable(ContextCompat.getColor(applicationContext, R.color.colorAccent))
        actionbar?.setBackgroundDrawable(drawableColor)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.background = null
//        ivFilter = findViewById(R.id.iv_toolbar_filter_id)
        floatingActionButton = findViewById(R.id.fab_mainActivity_id)
        floatingActionButton.setOnClickListener(this)
        // ivFilter.setOnClickListener(this)
        customFilterDialog = CustomFilterDialog(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.fab_mainActivity_id -> {
                val bottomSheet = CreateTaskSheet(this)
                bottomSheet.show(supportFragmentManager, "CreateTask")
            }
        }
    }

    override fun selectedFilter(taskFilter: String) {
        Log.d("TAG", "selectedFilter: $taskFilter")
    }
}