package com.example.todolist_crud_project.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.todolist_crud_project.daos.TodoDao
import com.example.todolist_crud_project.database.TodoDatabase
import com.example.todolist_crud_project.entities.TodoModel
//class TodoRepository @Inject constructor(val todoDao : TodoDao) {
    //private val todoDao : TodoDao = TodoDatabase.getDB(context).getTodoDao()
    class TodoRepository(val context: Context) {
        private val todoDao : TodoDao = TodoDatabase.getDB(context).getTodoDao()
    suspend fun insertTodo(todoModel: TodoModel){
            todoDao.addTodo(todoModel)
    }
    fun getAllTodos():LiveData<List<TodoModel>>{
        return todoDao.getAllTodos()
    }
    suspend fun updateTodo(todoModel: TodoModel) {
        todoDao.updateTodo(todoModel)
    }

    suspend fun deleteTodo(todoModel: TodoModel) {
       todoDao.deleteTodo(todoModel)
    }
}