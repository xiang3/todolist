package com.example.todolist.domain

interface TodoRepository {
    fun findAll(): List<Todo>
}
