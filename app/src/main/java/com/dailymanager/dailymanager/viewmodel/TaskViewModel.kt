package com.dailymanager.dailymanager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.dailymanager.dailymanager.androidroomdatabase.RoomDatabaseService
import com.dailymanager.dailymanager.androidroomdatabase.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepo: Repository
    private val readAllTask: LiveData<List<TaskModel>>

    init {
        val userDao = RoomDatabaseService.getDataBaseInstance(application).taskDao()
        userRepo = Repository(userDao)
        readAllTask = userDao.getAllTask()
    }

    fun addTask(taskModel: TaskModel) {
        GlobalScope.launch(Dispatchers.IO) {
            userRepo.addTask(taskModel)
        }
    }

    fun getAllTask() = readAllTask
}