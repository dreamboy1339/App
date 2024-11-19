package com.hjw.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.AppPreview

@Composable
fun IconText(
    modifier: Modifier = Modifier,
    title: String = "",
    iconUrl: String = "",
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.size(6.dp))
        if (iconUrl.isNotBlank()) {
            ImageIcon(iconUrl = iconUrl)
        }
    }
}

@Preview
@Composable
private fun IconTextPreview() {
    AppPreview {
        IconText(
            title = "클리어런스",
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
        )
    }
}
