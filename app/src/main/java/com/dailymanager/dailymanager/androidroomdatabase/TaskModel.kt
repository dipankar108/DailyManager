package com.dailymanager.dailymanager.androidroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_data")
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val taskTitle: String,
    val taskDesc: String,
    val taskDate: String,
    val taskTimeInMill: Long,
    val taskTime: String,
    val taskEvent: String
)