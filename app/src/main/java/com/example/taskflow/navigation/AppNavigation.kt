package com.example.taskflow.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskkflow.screen.SplashScreen
import com.example.taskkflow.screen.TaskDetailScreen
import com.example.taskkflow.screen.TaskFormScreen
import com.example.taskkflow.screen.TaskListScreen
import com.example.taskkflow.viewmodel.TaskViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val taskViewModel: TaskViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash
    ) {
        composable(Routes.Splash) {
            SplashScreen(navController)
        }

        composable(Routes.TaskList) {
            TaskListScreen(
                navController = navController,
                viewModel = taskViewModel
            )
        }

        composable(Routes.TaskForm) {
            TaskFormScreen(
                navController = navController,
                viewModel = taskViewModel
            )
        }

        composable(Routes.TaskDetail) { backStackEntry ->
            val taskId = backStackEntry.arguments
                ?.getString("taskId")
                ?.toIntOrNull()

            if (taskId != null) {
                TaskDetailScreen(
                    navController = navController,
                    taskId = taskId,
                    viewModel = taskViewModel
                )
            }
        }
    }
}