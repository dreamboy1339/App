package com.hjw.app.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.component.MDSIconText
import com.hjw.designsystem.theme.MDSColor

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
            titleColor = MDSColor.Red
        )
    }
}

@Preview
@Composable
private fun ErrorPreview() {
    AppPreview {
        ErrorBody(
            message = "오류가 발생했습니다."
        )
    }
}
