package com.dailymanager.dailymanager.viewmodel

import com.dailymanager.dailymanager.androidroomdatabase.TaskDao
import com.dailymanager.dailymanager.androidroomdatabase.TaskModel

class Repository(private val taskDao: TaskDao) {
    suspend fun addTask(taskModel: TaskModel) {
        taskDao.addTask(taskModel)
    }

}