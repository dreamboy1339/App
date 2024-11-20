@file:OptIn(ExperimentalCoilApi::class)

package com.hjw.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.toArgb
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import coil3.test.FakeImage
import com.hjw.designsystem.theme.AppTheme
import com.hjw.designsystem.theme.Gray

val previewHandler = AsyncImagePreviewHandler {
    FakeImage(color = Gray.copy(alpha = 0.5f).toArgb())
}

@Composable
fun AppPreview(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalAsyncImagePreviewHandler provides previewHandler) {
        AppTheme {
            content()
        }
    }
}
