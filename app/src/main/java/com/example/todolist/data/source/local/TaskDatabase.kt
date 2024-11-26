package com.example.todolist.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.data.model.Task


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun getTaskDao(): TaskDao

    companion object{
        @Volatile
        private var instance: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase{
            return instance ?: synchronized(this){
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "todolist_database"
                ).fallbackToDestructiveMigrationFrom()
                    .build()
                db
            }
        }
    }
}