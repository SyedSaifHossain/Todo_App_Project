package com.example.todolist_crud_project.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.todolist_crud_project.entities.TodoModel
import com.example.todolist_crud_project.repositories.TodoRepository

class TodoViewModel(application: Application): AndroidViewModel(application) {

    private val repository : TodoRepository
    init{
        repository = TodoRepository(application)
    }

    fun insertTodo(todoModel:TodoModel){

        repository.intertTodo(todoModel)
    }
    fun fetchAllTodos():LiveData<List<TodoModel>>{
        return repository.getAllTodos()
    }
}