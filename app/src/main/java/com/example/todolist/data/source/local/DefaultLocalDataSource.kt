package com.example.todolist.data.source.local

import com.example.todolist.data.model.Task
import com.example.todolist.data.source.DataSource
import kotlinx.coroutines.flow.Flow

class DefaultLocalDataSource(
    database: TaskDatabase
): DataSource.LocalDataSource {
    private val taskDao = database.getTaskDao()
    override suspend fun insertTask(task: Task) {
        taskDao.insert(task)
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.delete(task)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.update(task)
    }

    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAll()
    }
}