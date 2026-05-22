package com.example.taskflow.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskflow.ui.components.TaskCard
import com.example.taskflow.ui.components.FloatingButton
import com.example.taskflow.viewmodel.TaskViewModel
import com.example.taskflow.navigation.Routes
import com.example.taskflow.model.Priority

@Composable
fun TaskListScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {
    val tasks = viewModel.tasks.collectAsState().value

    val sortedTasks = tasks.sortedBy { task ->
        when (task.priority) {
            Priority.ALTA -> 1
            Priority.MEDIA -> 2
            Priority.BAJA -> 3
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingButton(onClick = { navController.navigate(Routes.TaskForm) })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sortedTasks) { task ->
                TaskCard(
                    task = task,
                    onClick = {
                        navController.navigate(
                            Routes.TaskDetail.replace("{taskId}", task.id.toString())
                        )
                    },
                    onDelete = {
                        viewModel.deleteTask(task)
                    },
                    onCompletedChange = { isCompleted ->
                        viewModel.updateTask(
                            task.copy(completed = isCompleted)
                        )
                    }
                )
            }
        }
    }
}