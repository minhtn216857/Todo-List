package com.example.todolist.ui

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.R
import com.example.todolist.data.model.Task
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.databinding.BottomSheetLayoutBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btnAddTask.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        showDialog()
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        val dialogBinding = BottomSheetLayoutBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        val newNameTask = dialogBinding.editNewNameTask.text.toString()
        val newDeadline = dialogBinding.editNewDeadline.text.toString()
        dialogBinding.btnDone.setOnClickListener {
            val newTask = Task(null, newNameTask, newDeadline)
            Toast.makeText(this, "Complete", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_bg)
        dialog.window?.setGravity(Gravity.BOTTOM)
    }
}