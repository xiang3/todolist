package com.example.todolist.domain

class TodoService(
    private val todoRepository: TodoRepository
) {

    fun getTodoList(): List<Todo> {
        return todoRepository.findAll()
    }

}
