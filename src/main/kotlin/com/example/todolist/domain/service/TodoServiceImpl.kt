package com.example.todolist.domain.service

import com.example.todolist.domain.Todo
import com.example.todolist.domain.dto.TodoDTO
import com.example.todolist.domain.repository.TodoRepository

class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {
    override fun getTodoList(): List<TodoDTO> {
        return todoRepository.findAll().map { it.toDTO() }
    }

    private fun Todo.toDTO(): TodoDTO = TodoDTO(id = id, title = title)
}
