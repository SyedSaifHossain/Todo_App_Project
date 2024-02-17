package com.example.todolist_crud_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist_crud_project.databinding.FragmentTodoBinding
import com.example.todolist_crud_project.dialog.TodoDeleteFragment
import com.example.todolist_crud_project.entities.TodoModel
import com.example.todolist_crud_project.utils.todo_delete
import com.example.todolist_crud_project.utils.todo_edit
import com.example.todolist_crud_project.viewmodels.TodoViewModel
//@AndroidEntryPoint
class TodoFragment : Fragment() {

    private lateinit var binding: FragmentTodoBinding
    private val todoViewModel : TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTodoBinding.inflate(inflater, container, false)

        val adaptar = TodoAdaptar(::todoAction)
        binding.recycler.layoutManager = LinearLayoutManager(activity)
        binding.recycler.adapter = adaptar

        todoViewModel.fetchAllTodos().observe(viewLifecycleOwner,{todoList->
            adaptar.submitList(todoList)
        })
        binding.fabButton.setOnClickListener{

            findNavController().navigate(R.id.fab_action)
        }

        return binding.root
    }
    private fun todoAction(todoModel: TodoModel, tag:String){

        when(tag){
            todo_edit-> todoViewModel.updateTodo(todoModel)
            todo_delete->{
                TodoDeleteFragment{

                    todoViewModel.deleteTodo(todoModel)
                }.show(childFragmentManager,"delete")
            }

        }
    }
}