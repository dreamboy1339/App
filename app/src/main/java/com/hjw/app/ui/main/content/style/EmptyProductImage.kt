package com.hjw.app.ui.main.content.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.designsystem.component.content.MDSProductImage

@Composable
fun EmptyProductImage(modifier: Modifier) {
    MDSProductImage(
        modifier = modifier,
        thumbnailUrl = "",
        hasCoupon = false
    )
}
