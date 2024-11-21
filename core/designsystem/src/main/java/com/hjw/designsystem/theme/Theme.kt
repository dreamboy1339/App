package com.hjw.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val colorScheme = lightColorScheme(
    primary = AppColor.Black,
    secondary = AppColor.White,
    tertiary = AppColor.Gray,
    background = AppColor.LightGray,
    surface = AppColor.White
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
