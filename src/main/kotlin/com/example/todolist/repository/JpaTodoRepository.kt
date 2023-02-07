package com.example.todolist.repository

import com.example.todolist.repository.entity.TodoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaTodoRepository : JpaRepository<TodoEntity, String> {
}
