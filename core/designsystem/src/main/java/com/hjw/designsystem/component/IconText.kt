package com.hjw.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.theme.Black
import com.hjw.designsystem.theme.Spacing

@Composable
fun IconText(
    leftIcon: Boolean = false,
    title: String = "",
    rightIcon: Boolean = false,
    iconUrl: String = "",
    titleColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (leftIcon) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Refresh"
            )
            Spacer(modifier = Modifier.size(Spacing.xs))
        }

        Text(
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = textStyle,
            color = titleColor
        )

        if (rightIcon && iconUrl.isNotBlank()) {
            Spacer(modifier = Modifier.size(Spacing.xs))
            ImageIcon(iconUrl = iconUrl)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IconTextWithLeftIconPreview() {
    AppPreview {
        IconText(
            leftIcon = true,
            title = "클리어런스",
            titleColor = Black,
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IconTextWithRightIconPreview() {
    AppPreview {
        IconText(
            title = "클리어런스",
            rightIcon = true,
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
            titleColor = Black,
            textStyle = MaterialTheme.typography.titleLarge,
        )
    }
}
