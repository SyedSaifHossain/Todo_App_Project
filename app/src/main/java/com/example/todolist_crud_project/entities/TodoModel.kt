package com.example.todolist_crud_project.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")

data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0,
    var name: String,
    var priority: String,
    var date: Long,
    var time: Long,
    @ColumnInfo(name ="Completed")
    var isCompleted: Boolean = false
)