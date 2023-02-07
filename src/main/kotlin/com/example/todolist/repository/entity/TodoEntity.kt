package com.example.todolist.repository.entity

import com.example.todolist.NoArg
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="todo")
@NoArg
data class TodoEntity(
    @Id
    val id: String,
    var title: String
) {
}
