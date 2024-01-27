package com.example.todolist_crud_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist_crud_project.database.TodoDatabase
import com.example.todolist_crud_project.databinding.FragmentNewTodoBinding
import com.example.todolist_crud_project.dialog.DatePickerDialog
import com.example.todolist_crud_project.dialog.TimePickerDialog
import com.example.todolist_crud_project.entities.TodoModel
import com.example.todolist_crud_project.viewmodels.TodoViewModel
import getFormattedDateTime

class NewTodoFragment : Fragment() {
    private lateinit var binding: FragmentNewTodoBinding
    private var priority = "Normal"
    private var timeInMillis = System.currentTimeMillis()
    private var dateInMillis = System.currentTimeMillis()

    private val todoViewModel : TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentNewTodoBinding.inflate(inflater, container, false)

        binding.rgButton.setOnCheckedChangeListener { group, checkedId ->

            var groupButton = group.findViewById<RadioButton>(checkedId)

            priority = groupButton.text.toString()
        }
        binding.dateButton.setOnClickListener {
            DatePickerDialog { timeStamp ->

                dateInMillis = timeStamp
                binding.dateButton.text = getFormattedDateTime(dateInMillis, "dd/MM/yyyy")

            }.show(childFragmentManager, "date_picker")

        }
        binding.timeButton.setOnClickListener {
            TimePickerDialog { timeStamp ->
                timeInMillis = timeStamp

                binding.timeButton.text = getFormattedDateTime(timeInMillis, "hh:mm a")
            }.show(childFragmentManager, "time_picker")

        }
        binding.saveButton.setOnClickListener {
            var todoName = binding.todoName.text.toString()
            if (todoName.isEmpty()) {
                binding.saveButton.error = "Please provid a valid todo name"
                return@setOnClickListener
            }
            var todo = TodoModel(name = todoName, priority = priority, date = dateInMillis, time = timeInMillis)
            todoViewModel.insertTodo(todo)

            findNavController().navigate(R.id.todo_list_action)
        }
        return binding.root
    }
}