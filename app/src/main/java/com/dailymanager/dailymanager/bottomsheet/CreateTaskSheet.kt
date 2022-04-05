package com.dailymanager.dailymanager.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dailymanager.dailymanager.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateTaskSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.createtask, container, false)
        return view
    }
}