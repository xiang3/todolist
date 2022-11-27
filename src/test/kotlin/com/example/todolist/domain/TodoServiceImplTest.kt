package com.example.todolist.domain

import com.example.todolist.domain.dto.TodoDTO
import com.example.todolist.domain.repository.TodoRepository
import com.example.todolist.domain.service.TodoServiceImpl
import net.bytebuddy.utility.RandomString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import java.util.*

@ExtendWith(MockitoExtension::class)
class TodoServiceImplTest {
    @Mock
    private lateinit var todoRepository: TodoRepository

    @InjectMocks
    private lateinit var todoDomainService: TodoServiceImpl

    @Test
    fun `should return todoList when findAll todoList`() {
        val todo: Todo = generateTodo()
        whenever(todoRepository.findAll()).thenReturn(listOf(todo))
        val todoList: List<TodoDTO> = todoDomainService.getTodoList()
        assertThat(todoList).containsOnly(TodoDTO(id = todo.id, title = todo.title))
    }

    private fun generateTodo(): Todo = Todo(randomId(), RandomString.make())

    private fun randomId(): String = UUID.randomUUID().toString()

}