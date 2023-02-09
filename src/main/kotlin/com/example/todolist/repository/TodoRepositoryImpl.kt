package com.example.todolist.repository

import com.example.todolist.domain.Todo
import com.example.todolist.domain.repository.TodoRepository
import com.example.todolist.repository.entity.TodoEntity
import org.springframework.stereotype.Component

@Component
class TodoRepositoryImpl(private val jpaTodoRepository: JpaTodoRepository) : TodoRepository {
    override fun findAll(): List<Todo> {
        return jpaTodoRepository.findAll().map(this::toTodo)
    }

    fun save(todo: Todo) {
        jpaTodoRepository.save(todo.toEntity())
    }

    private fun toTodo(it: TodoEntity): Todo = Todo(id = it.id, title = it.title)
}

private fun Todo.toEntity() = TodoEntity(id = id, title = title)
