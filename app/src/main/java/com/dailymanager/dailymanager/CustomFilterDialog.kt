package com.dailymanager.dailymanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class CustomFilterDialog(private val listener: FilterCallBack) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.filterdialog, container, false)
        val cancel: Button = rootView.findViewById(R.id.btn_cencalFilter_id)
        val rootRadio: RadioGroup = rootView.findViewById(R.id.radioGroup)
        rootRadio.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.rbtn_allTask_id -> {
                    listener.selectedFilter("All Task")
                    dismiss()
                }
                R.id.rbtn_completeTask_id -> {
                    listener.selectedFilter("Complete Task")
                    dismiss()
                }
                R.id.rbtn_incompleteTask_id -> {
                    listener.selectedFilter("Incomplete Task")
                    dismiss()
                }
                R.id.rbtn_upcomingTask_id -> {
                    listener.selectedFilter("Upcoming Task")
                    dismiss()
                }
            }
        }
        cancel.setOnClickListener {
            dismiss()
        }
        return rootView
    }
}