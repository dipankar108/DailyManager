package com.dailymanager.dailymanager.androidroomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskModel::class], exportSchema = false, version = 1)
abstract class RoomDatabaseService : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: RoomDatabaseService? = null
        fun getDataBaseInstance(context: Context): RoomDatabaseService {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    RoomDatabaseService::class.java,
                    "databaseInstance"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}