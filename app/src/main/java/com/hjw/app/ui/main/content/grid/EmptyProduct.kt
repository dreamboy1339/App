package com.hjw.app.ui.main.content.grid

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.designsystem.component.content.MDSProduct

@Composable
fun EmptyProduct(modifier: Modifier) {
    MDSProduct(
        modifier = modifier,
        linkUrl = "",
        thumbnailUrl = "",
        brandName = "",
        price = -1,
        saleRate = -1,
        hasCoupon = false
    )
}