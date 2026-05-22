package com.example.taskflow.model

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority,
    val completed: Boolean = false
)

enum class Priority {
    ALTA,
    MEDIA,
    BAJA
}