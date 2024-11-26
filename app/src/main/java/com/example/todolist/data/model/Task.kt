package com.example.todolist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.Date

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    @SerializedName("name") val nameTask: String? = "",
    @SerializedName("deadline") val deadline: String?
) {
}