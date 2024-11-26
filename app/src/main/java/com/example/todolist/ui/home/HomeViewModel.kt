package com.example.todolist.ui.home

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.model.Task
import com.example.todolist.utils.Utils
import java.util.Date

class HomeViewModel(): ViewModel() {
    private var _listTasks = MutableLiveData<List<Task>>()
    val listTasks: LiveData<List<Task>> = _listTasks

    private var testListTasks: MutableList<Task> = mutableListOf()

    fun loadData(context: Context?){
        testListTasks.add(Task("Thi TOEIC", Utils.stringToDate("12/12/2024")))
        testListTasks.add(Task("Dạy học", Utils.stringToDate("27/11/2024")))
        testListTasks.add(Task("Thi Chuỗi Thời Gian", Utils.stringToDate("29/11/2024")))
        testListTasks.add(Task("Nộp Đồ Án 2", Date(3/12/2024)))
        testListTasks.add(Task("Dạy học", Utils.stringToDate("27/11/2024")))
        testListTasks.add(Task("Thi Chuỗi Thời Gian", Utils.stringToDate("29/11/2024")))
        testListTasks.add(Task("Nộp Đồ Án 2", Date(3/12/2024)))
        _listTasks.value = testListTasks
    }

    companion object{
        var instance: HomeViewModel? = null
            get(){
                if(field == null){
                    field = HomeViewModel()
                }
                return field
            }
            private set
    }

}