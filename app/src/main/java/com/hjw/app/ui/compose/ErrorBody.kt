package com.hjw.app.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hjw.designsystem.component.MDSIconText
import com.hjw.designsystem.theme.AppColor

@Composable
fun ErrorBody(
    message: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        MDSIconText(
            textStyle = MaterialTheme.typography.bodyMedium,
            title = message,
            titleColor = AppColor.Red
        )
    }
}
