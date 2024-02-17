package com.example.todolist_crud_project.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolist_crud_project.entities.TodoModel
import com.example.todolist_crud_project.repositories.TodoRepository
import kotlinx.coroutines.launch
//@HiltViewModel

//class TodoViewModel @Inject constructor(val repository : TodoRepository): ViewModel() {

   // private val repository : TodoRepository = TodoRepository(application)

    class TodoViewModel(application: Application): AndroidViewModel(application) {

        private val repository : TodoRepository
        init{
            repository = TodoRepository(application)
        }

        fun insertTodo(todoModel:TodoModel){
        viewModelScope.launch {
             repository.insertTodo(todoModel)
        }
    }
    fun fetchAllTodos():LiveData<List<TodoModel>>{
        return repository.getAllTodos()
    }

    fun updateTodo(todoModel: TodoModel) {
        todoModel.isCompleted = !todoModel.isCompleted
        viewModelScope.launch {
        repository.updateTodo(todoModel)
        }
    }

    fun deleteTodo(todoModel: TodoModel) {
        viewModelScope.launch {

            repository.deleteTodo(todoModel)
        }
    }
}