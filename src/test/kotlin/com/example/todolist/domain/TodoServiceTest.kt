package com.example.todolist.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
class TodoServiceTest {
    @Mock
    private lateinit var todoRepository: TodoRepository

    @InjectMocks
    private lateinit var todoService: TodoService

    @Test
    fun `should return todoList when findAll todoList`() {
        val todo: Todo = generateTodo()
        whenever(todoRepository.findAll()).thenReturn(listOf(todo))
        val todoList: List<Todo> = todoService.getTodoList()
        assertThat(todoList).isEqualTo(listOf(todo))
    }

    private fun generateTodo(): Todo = Todo()

}