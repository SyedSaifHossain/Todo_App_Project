package com.example.todolist_crud_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist_crud_project.database.TodoDatabase
import com.example.todolist_crud_project.databinding.FragmentTodoBinding
import com.example.todolist_crud_project.viewmodels.TodoViewModel


class TodoFragment : Fragment() {

    private lateinit var binding: FragmentTodoBinding
    private val todoViewModel : TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false)

        todoViewModel.fetchAllTodos().observe(viewLifecycleOwner,{todoList->
            Toast.makeText(activity,"{$todoList}",Toast.LENGTH_SHORT).show()
        })
        binding.fabButton.setOnClickListener{

            findNavController().navigate(R.id.fab_action)
        }

        return binding.root
    }
}