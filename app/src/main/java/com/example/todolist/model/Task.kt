package com.example.todolist.model

import java.util.Date

data class Task(
    val nameTask: String? = "",
    val deadline: Date?
) {
}