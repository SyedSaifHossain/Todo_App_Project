package com.example.todolist_crud_project.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.todolist_crud_project.daos.TodoDao
import com.example.todolist_crud_project.database.TodoDatabase
import com.example.todolist_crud_project.entities.TodoModel

class TodoRepository(val context: Context) {
    private val todoDao : TodoDao
            init{
                todoDao = TodoDatabase.getDB(context).getTodoDao()
            }

    suspend fun intertTodo(todoModel: TodoModel){
            todoDao.addTodo(todoModel)
    }
    fun getAllTodos():LiveData<List<TodoModel>>{
        return todoDao.getAllTodos()
    }
    suspend fun updateTodo(todoModel: TodoModel) {
        return todoDao.updateTodo(todoModel)
    }

    suspend fun deleteTodo(todoModel: TodoModel) {
       return todoDao.deleteTodo(todoModel)
    }
}