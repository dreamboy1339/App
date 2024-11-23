package com.hjw.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.hjw.designsystem.AppPreview

@Composable
fun MDSImageIcon(
    iconUrl: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = iconUrl,
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ImageIconPreview() {
    AppPreview {
        MDSImageIcon(iconUrl = "https://image.msscdn.net/icons/mobile/clock.png")
    }
}
