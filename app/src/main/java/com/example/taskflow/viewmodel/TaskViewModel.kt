package com.example.taskflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskflow.model.Task
import com.example.taskflow.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import com.example.taskflow.model.Priority
class TaskViewModel : ViewModel() {

    private val repository = TaskRepository()

    val tasks: StateFlow<List<Task>> = repository.tasks
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addTask(
        title: String,
        description: String,
        priority: Priority
    ) {
        val newTask = Task(
            id = System.currentTimeMillis().toInt(),
            title = title,
            description = description,
            priority = priority,
            completed = false
        )

        repository.addTask(newTask)
    }

    fun updateTask(task: Task) {
        repository.updateTask(task)
    }

    fun deleteTask(task: Task) {
        repository.deleteTask(task)
    }
}