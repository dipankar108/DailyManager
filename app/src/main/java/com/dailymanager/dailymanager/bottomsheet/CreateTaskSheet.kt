package com.dailymanager.dailymanager.bottomsheet

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.dailymanager.dailymanager.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.*

class CreateTaskSheet(private val appContext: Context) : BottomSheetDialogFragment() {
    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.createtask, container, false)
        val picAdate: EditText = view.findViewById(R.id.taskDate)
        val picTime: EditText = view.findViewById(R.id.taskTime)
        picAdate.setOnTouchListener { _, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_UP) {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val day = calendar.get(Calendar.DAY_OF_MONTH)
                val month = calendar.get(Calendar.MONTH)
                val datePickerDialog = DatePickerDialog(
                    appContext,
                    { _, myear, mmonth, mday ->
                        val fullDate = "$myear-$mmonth-$mday"
                        picAdate.setText(fullDate)
                    },
                    year,
                    month,
                    day
                )
                datePickerDialog.show()
            }
            return@setOnTouchListener true
        }
        picTime.setOnTouchListener { _, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_UP) {
                val calendar = Calendar.getInstance()
                val hour = calendar.get(Calendar.HOUR)
                val minute = calendar.get(Calendar.MINUTE)
                val datePickerDialog = TimePickerDialog(
                    appContext,
                    { _: TimePicker, i: Int, i1: Int ->
                        var fullDate = ""
                        fullDate = if (i < 12) {
                            "$i:$i1 AM"
                        } else "$i:$i1 PM"
                        picTime.setText(fullDate)
                    },
                    hour,
                    minute,
                    false
                )
                datePickerDialog.show()
            }
            return@setOnTouchListener true
        }
        val addTaskTitle: EditText = view.findViewById(R.id.addTaskTitle)
        val addTaskDesc: EditText = view.findViewById(R.id.addTaskDescription)
        val pushTasktoDataBase: Button = view.findViewById(R.id.btn_addTask)
        val addTaskEvent: EditText = view.findViewById(R.id.taskEvent)
        pushTasktoDataBase.setOnClickListener {
            val title = addTaskTitle.text.toString()
            val desc = addTaskDesc.text.toString()
            val taskDate = picAdate.text.toString()
            val taskTime = picTime.text.toString()
            val taskEvent = addTaskEvent.text.toString()
            if (validateFields(title, desc, taskDate, taskTime, "empty")) {
                createTask(title, desc, taskDate, taskTime, taskEvent)
            }
        }
        return view
    }

    private fun createTask(
        title: String,
        desc: String,
        taskDate: String,
        taskTime: String,
        taskEvent: String
    ) {
        Log.d("TAG", "createTask: Called")
    }

    private fun validateFields(
        title: String,
        desc: String,
        taskDate: String,
        taskTime: String,
        taskEvent: String
    ): Boolean {
        when {
            title.isEmpty() -> {
                Toast.makeText(activity, "Please enter a valid title", Toast.LENGTH_SHORT).show();
                return false;
            }
            desc.isEmpty() -> {
                Toast.makeText(activity, "Please enter a valid description", Toast.LENGTH_SHORT)
                    .show();
                return false;
            }
            taskDate.isEmpty() -> {
                Toast.makeText(activity, "Please enter date", Toast.LENGTH_SHORT).show();
                return false;
            }
            taskTime.isEmpty() -> {
                Toast.makeText(activity, "Please enter time", Toast.LENGTH_SHORT).show();
                return false;
            }
            taskEvent.isEmpty() -> {
                Toast.makeText(activity, "Please enter an event", Toast.LENGTH_SHORT).show();
                return false;
            }
            else -> {
                return true;
            }
        }
    }
}