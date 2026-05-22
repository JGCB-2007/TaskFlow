package com.example.taskflow.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskflow.navigation.Routes
import kotlinx.coroutines.delay
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.MaterialTheme

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        navController.navigate(Routes.TaskList) {
            popUpTo(Routes.Splash) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = android.R.drawable.ic_dialog_info),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("TaskFlow", style = MaterialTheme.typography.headlineMedium)
        }
    }
}