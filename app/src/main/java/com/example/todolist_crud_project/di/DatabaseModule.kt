package com.example.todolist_crud_project.di

import android.content.Context
import com.example.todolist_crud_project.daos.TodoDao
import com.example.todolist_crud_project.database.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module

object DatabaseModule {
    @Provides
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao {
        return TodoDatabase.getDB(context).getTodoDao()
    }
}