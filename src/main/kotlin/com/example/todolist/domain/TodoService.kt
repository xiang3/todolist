package com.example.todolist.domain

interface TodoService {
    fun getTodoList(): List<Todo>
}