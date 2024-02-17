package com.example.todolist_crud_project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist_crud_project.daos.TodoDao
import com.example.todolist_crud_project.entities.TodoModel

@Database(entities = [TodoModel::class], version=1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao

    companion object {
        private var todoDatabase: TodoDatabase? = null
        fun getDB(context: Context): TodoDatabase {

            return todoDatabase ?: synchronized(this) {
                val db = Room.databaseBuilder(context, TodoDatabase::class.java, "todo_database")
                    .build()
                todoDatabase = db
                db
            }
        }
    }

}