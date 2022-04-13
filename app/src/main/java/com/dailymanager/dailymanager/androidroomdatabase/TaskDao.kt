package com.dailymanager.dailymanager.androidroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTask(taskModel: TaskModel)

    @Query("SELECT * FROM task_data")
    fun getAllTask(): LiveData<List<TaskModel>>
}