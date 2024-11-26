package com.example.todolist.data.source

import com.example.todolist.data.model.Task
import kotlinx.coroutines.flow.Flow

class DefaultRepository(
    private val localDataSource: DataSource.LocalDataSource
): Repository.LocalRepository {
    override suspend fun insertTask(task: Task) {
        localDataSource.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        localDataSource.deleteTask(task)
    }

    override suspend fun updateTask(task: Task) {
        localDataSource.updateTask(task)
    }

    override fun getAllTasks(): Flow<List<Task>> {
        return localDataSource.getAllTasks()
    }
}