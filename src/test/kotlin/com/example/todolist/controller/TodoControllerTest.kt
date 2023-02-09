package com.example.todolist.controller

import com.example.todolist.domain.Todo
import com.example.todolist.domain.service.TodoService
import net.bytebuddy.utility.RandomString
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class TodoControllerTest {
    @Mock
    private lateinit var todoService: TodoService

    @InjectMocks
    private lateinit var todoController: TodoController

    @Test
    fun `should return all todo list when call get todo`() {
        val todo = generateTodo()
        whenever(todoService.getTodoList()).thenReturn(listOf(todo))

        val todoList = todoController.getTodoList()
        Assertions.assertThat(todoList).containsOnly(TodoResponse(todo.id, todo.title))
    }

    private fun generateTodo(): Todo = Todo(UUID.randomUUID().toString(), RandomString.make())
}