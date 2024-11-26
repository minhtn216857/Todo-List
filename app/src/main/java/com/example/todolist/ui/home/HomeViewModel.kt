package com.example.todolist.ui.home

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.model.Task
import com.example.todolist.data.source.Repository
import com.example.todolist.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

class HomeViewModel(
    private val repository: Repository
): ViewModel() {
    private var _listTasks = MutableLiveData<List<Task>>()
    val listTasks: LiveData<List<Task>> = _listTasks

    private var testListTasks: MutableList<Task> = mutableListOf()

    fun loadTaskData(){
        viewModelScope.launch(Dispatchers.IO){
            (repository as Repository.LocalRepository).getAllTasks().collect{result ->
                _listTasks.postValue(result)
            }
        }
    }

}

class HomeViewModelFactory(
    private val repository: Repository
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(repository) as T
        }
        // Ném ra ngoại lệ nếu modelClass không phải là RegisterViewModel
        throw IllegalArgumentException("Argument must be class RegisterViewModel")
    }
}