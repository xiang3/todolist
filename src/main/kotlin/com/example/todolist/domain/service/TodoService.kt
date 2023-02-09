package com.example.todolist.domain.service

import com.example.todolist.domain.Todo

interface TodoService {
    fun getTodoList(): List<Todo>
}