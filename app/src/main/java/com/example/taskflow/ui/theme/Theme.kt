package com.example.taskflow.ui.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val TaskFlowColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryBlue,
    background = BackgroundLight,
    surface = CardWhite,
    onPrimary = CardWhite,
    onBackground = TextDark,
    onSurface = TextDark
)

@Composable
fun TaskFlowTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = TaskFlowColorScheme,
        typography = Typography,
        content = content
    )
}