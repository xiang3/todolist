package com.example.todolist.domain

class DomainTodoService(
    private val todoRepository: TodoRepository
) : TodoService {
    override fun getTodoList(): List<Todo> {
        return todoRepository.findAll()
    }
}
