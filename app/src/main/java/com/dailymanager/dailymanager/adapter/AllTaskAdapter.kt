package com.dailymanager.dailymanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailymanager.dailymanager.R
import com.dailymanager.dailymanager.androidroomdatabase.TaskModel

class AllTaskAdapter : RecyclerView.Adapter<AllTaskAdapter.taskAdapterViewHolder>() {
    private var allTask = listOf<TaskModel>()

    class taskAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        taskAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.alltaskview, parent, false)
        )

    override fun onBindViewHolder(holder: taskAdapterViewHolder, position: Int) {

    }

    override fun getItemCount() = allTask.size
    fun setAllTask(allTask: List<TaskModel>) {
        this.allTask = allTask
    }
}