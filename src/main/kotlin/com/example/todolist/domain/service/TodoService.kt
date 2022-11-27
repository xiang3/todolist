package com.example.todolist.domain.service

import com.example.todolist.domain.dto.TodoDTO

interface TodoService {
    fun getTodoList(): List<TodoDTO>
}