package com.example.todolist.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
object Utils {
    private const val DATE_FORMAT = "dd/MM/yyyy"

    private val dateFormat = SimpleDateFormat(DATE_FORMAT)

    fun stringToDate(dateStr: String?): Date?{
        return try {
            dateFormat.parse(dateStr!!)
        }catch (e: ParseException){
            null
        }
    }

    fun dateToString(date: Date?): String?{
        return dateFormat.format(date!!)
    }

}