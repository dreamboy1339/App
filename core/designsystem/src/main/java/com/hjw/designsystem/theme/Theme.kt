package com.hjw.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val colorScheme = lightColorScheme(
    primary = MDSColor.Black,
    secondary = MDSColor.White,
    tertiary = MDSColor.Gray,
    background = MDSColor.LightGray,
    surface = MDSColor.White
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
