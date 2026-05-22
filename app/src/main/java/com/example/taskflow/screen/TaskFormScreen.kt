package com.example.taskflow.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskflow.model.Task
import com.example.taskflow.viewmodel.TaskViewModel
import kotlinx.coroutines.launch

@Composable
fun TaskFormScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Agregar Tarea", style = MaterialTheme.typography.headlineSmall)

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

            Button(onClick = {
                if (title.isNotBlank() && description.isNotBlank()) {
                    scope.launch {
                        viewModel.addTask(
                            Task(
                                id = System.currentTimeMillis().toInt(),
                                title = title,
                                description = description
                            )
                        )
                        navController.popBackStack()
                    }
                }
            }) {
                Text("Agregar")
            }
        }
    }
}