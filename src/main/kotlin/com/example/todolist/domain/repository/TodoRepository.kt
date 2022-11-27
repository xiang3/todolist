package com.example.todolist.domain.repository

import com.example.todolist.domain.Todo


interface TodoRepository {
    fun findAll(): List<Todo>
}
