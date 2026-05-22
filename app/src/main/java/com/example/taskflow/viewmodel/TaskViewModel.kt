package com.example.taskflow.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskflow.model.Task
import com.example.taskflow.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class TaskViewModel : ViewModel() {

    private val repository = TaskRepository()

    val tasks: StateFlow<List<Task>> = repository.tasks
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addTask(task: Task) = repository.addTask(task)
    fun updateTask(task: Task) = repository.updateTask(task)
    fun deleteTask(task: Task) = repository.deleteTask(task)
}