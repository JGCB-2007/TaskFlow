package com.example.taskflow.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskflow.viewmodel.TaskViewModel

@Composable
fun TaskDetailScreen(
    navController: NavController,
    taskId: Int,
    viewModel: TaskViewModel
) {
    val tasks by viewModel.tasks.collectAsState()
    val task = tasks.find { it.id == taskId }

    if (task == null) {
        Text("Tarea no encontrada")
        return
    }

    var title by remember(task.id) { mutableStateOf(task.title) }
    var description by remember(task.id) { mutableStateOf(task.description) }
    var completed by remember(task.id) { mutableStateOf(task.completed) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Editar tarea", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Completada")
        Checkbox(checked = completed, onCheckedChange = { completed = it })

        Button(onClick = {
            viewModel.updateTask(
                task.copy(
                    title = title,
                    description = description,
                    completed = completed
                )
            )
            navController.popBackStack()
        }) {
            Text("Guardar cambios")
        }
    }
}