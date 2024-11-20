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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.theme.Spacing

@Composable
fun IconText(
    title: String = "",
    iconUrl: String = "",
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.size(Spacing.xs))

        if (iconUrl.isNotBlank()) {
            ImageIcon(iconUrl = iconUrl)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IconTextPreview() {
    AppPreview {
        IconText(
            title = "클리어런스",
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
        )
    }
}
