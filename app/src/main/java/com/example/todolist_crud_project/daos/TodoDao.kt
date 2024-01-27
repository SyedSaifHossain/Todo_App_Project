package com.example.todolist_crud_project.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist_crud_project.entities.TodoModel

@Dao
interface TodoDao {
    @Insert
    suspend fun addTodo(todoModel : TodoModel)
    @Update
    suspend fun updateTodo(todoModel : TodoModel)
    @Delete
    suspend fun deleteTodo(todoModel : TodoModel)
    @Query("select * from todoTable order by id desc")
    fun getAllTodos(): LiveData<List<TodoModel>>
}