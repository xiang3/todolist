package com.example.todolist.controller

import com.example.todolist.domain.Todo
import com.example.todolist.domain.service.TodoService
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(private val todoService: TodoService) {

    fun getTodoList(): List<TodoResponse> = todoService.getTodoList().map { todo: Todo -> todo.toResponse() }

    private fun Todo.toResponse(): TodoResponse = TodoResponse(id = id, title = title)

}