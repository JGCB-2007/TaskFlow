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
import com.example.taskflow.R

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
                    painter = painterResource(id = R.drawable.taskflow_logo),
                    contentDescription = "Logo TaskFlow",
                    modifier = Modifier.size(180.dp)
                )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}