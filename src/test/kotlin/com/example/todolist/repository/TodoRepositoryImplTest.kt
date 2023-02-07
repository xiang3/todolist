package com.example.todolist.repository

import com.example.todolist.domain.Todo
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
    private lateinit var jpaTodoRepository: JpaTodoRepository

    @Autowired
    private lateinit var todoRepositoryImpl: TodoRepositoryImpl

    @Test
    fun `should return todo list when call jpaTodoRepo`() {
        val todoEntity: TodoEntity = generateTodoEntity()
        jpaTodoRepository.save(todoEntity)
        with(todoRepositoryImpl.findAll()) {
            assertThat(this).containsOnly(toTodo(todoEntity))
        }
    }

    private fun generateTodoEntity(): TodoEntity = TodoEntity(UUID.randomUUID().toString(), RandomString.make())

    private fun toTodo(it: TodoEntity): Todo = Todo(id = it.id, title = it.title)
}