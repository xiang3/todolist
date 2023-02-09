package com.example.todolist.domain.service

import com.example.todolist.domain.Todo
import com.example.todolist.domain.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {
    override fun getTodoList(): List<Todo> {
        return todoRepository.findAll()
    }
}
