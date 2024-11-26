package com.example.todolist.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.todolist.R
import com.example.todolist.TaskApplication
import com.example.todolist.databinding.FragmentHomeBinding
import com.example.todolist.data.model.Task
import com.example.todolist.data.source.Repository

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarMain.setTitle("TO DO LIST")
        setupViewModel()
        setupRecycler()
    }

    private fun setupViewModel(){
        val repository = (requireActivity().application as TaskApplication).repository

        homeViewModel = ViewModelProvider(
            requireActivity(),
            HomeViewModelFactory(repository)
        )[HomeViewModel::class.java]

        taskViewModel = ViewModelProvider(requireActivity())[TaskViewModel::class.java]

        homeViewModel.loadTaskData()
    }

    private fun setupRecycler(){
        val adapter = TaskAdapter(listener = object : TaskAdapter.OnItemClickListener{
            override fun OnItemClick(task: Task) {
                taskViewModel.setSelectedTask(task)
            }
        })

        binding.recycleTask.adapter = adapter


    }

}