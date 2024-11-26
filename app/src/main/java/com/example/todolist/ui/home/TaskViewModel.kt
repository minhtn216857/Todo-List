package com.example.todolist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.model.Task

class TaskViewModel: ViewModel() {
    private val selectedTask = MutableLiveData<Task>()

    fun setSelectedTask(task: Task){
        selectedTask.value = task
    }

    fun getSelectedTask(): LiveData<Task>{
        return selectedTask
    }
}