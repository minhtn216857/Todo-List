package com.example.todolist

import android.app.Application
import com.example.todolist.data.source.DataSource
import com.example.todolist.data.source.DefaultRepository
import com.example.todolist.data.source.Repository
import com.example.todolist.data.source.local.DefaultLocalDataSource
import com.example.todolist.data.source.local.TaskDatabase

class TaskApplication: Application() {
    private lateinit var localDataSource: DataSource.LocalDataSource
    lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()
        setupViewModel()
    }

    private fun setupViewModel(){
        val database = TaskDatabase.getDatabase(applicationContext)
        localDataSource = DefaultLocalDataSource(database)
        repository = DefaultRepository(localDataSource)
    }
}