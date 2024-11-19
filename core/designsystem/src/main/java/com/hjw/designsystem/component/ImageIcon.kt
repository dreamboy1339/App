package com.hjw.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.hjw.designsystem.AppPreview

@Composable
fun ImageIcon(
    iconUrl: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(iconUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview
@Composable
private fun ImageIconPreview() {
    AppPreview {
        ImageIcon(iconUrl = "https://image.msscdn.net/icons/mobile/clock.png")
    }
}
