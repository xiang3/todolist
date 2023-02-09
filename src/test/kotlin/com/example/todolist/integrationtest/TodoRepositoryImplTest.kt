package com.example.todolist.integrationtest

import com.example.todolist.domain.Todo
import com.example.todolist.repository.JpaTodoRepository
import com.example.todolist.repository.TodoRepositoryImpl
import com.example.todolist.repository.entity.TodoEntity
import net.bytebuddy.utility.RandomString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@DataJpaTest(excludeAutoConfiguration = [TodoRepositoryImpl::class])
@Import(value = [TodoRepositoryImpl::class])
internal class TodoRepositoryImplTest {
    @Autowired
    private lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @Test
    fun `should return todo list when call jpaTodoRepo`() {
        val todo: Todo= generateTodo()
        todoRepositoryImpl.save(todo)
        with(todoRepositoryImpl.findAll()) {
            assertThat(this).containsOnly(todo)
        }
    }

    private fun generateTodo(): Todo = Todo(UUID.randomUUID().toString(), RandomString.make())
}