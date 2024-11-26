package com.example.todolist.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todolist.R
import com.example.todolist.databinding.TaskItemBinding
import com.example.todolist.data.model.Task
import com.example.todolist.utils.Utils

class TaskAdapter(
    private val listTask: MutableList<Task> = mutableListOf(),
    private val listener: OnItemClickListener
) :RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: TaskItemBinding,
        private val listener: OnItemClickListener
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task){
            binding.textNameTask.text = task.nameTask
            binding.textDeadline.text = task.deadline
            binding.root.setOnClickListener{
                listener.OnItemClick(task)
            }
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setTasks(tasks: List<Task>?){
        listTask.clear()
        listTask.addAll(tasks!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterView =
            LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        val binding = TaskItemBinding.bind(adapterView)
        return ViewHolder(binding, listener)
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = listTask[position]
        holder.bind(task)
    }

    interface OnItemClickListener{
        fun OnItemClick(task: Task)
    }

}