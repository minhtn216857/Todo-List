package com.example.todolist.data.source

import com.example.todolist.data.model.Task
import kotlinx.coroutines.flow.Flow

interface Repository {
    interface LocalRepository: Repository{
        suspend fun insertTask(task: Task)

        suspend fun deleteTask(task: Task)

        suspend fun updateTask(task: Task)

        fun getAllTasks(): Flow<List<Task>>
    }
}