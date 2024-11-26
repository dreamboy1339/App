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
import com.hjw.designsystem.theme.MDSColor
import com.hjw.designsystem.theme.Size
import com.hjw.designsystem.theme.Spacing

@Composable
fun MDSIconText(
    textStyle: TextStyle,
    leftIcon: Boolean = false,
    title: String = "",
    rightIcon: Boolean = false,
    iconUrl: String = "",
    titleColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
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
            MDSImageIcon(
                iconUrl = iconUrl,
                modifier = Modifier.size(Size.s)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IconTextWithLeftIconPreview() {
    AppPreview {
        MDSIconText(
            leftIcon = true,
            title = "클리어런스",
            titleColor = MDSColor.Black,
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IconTextWithRightIconPreview() {
    AppPreview {
        MDSIconText(
            title = "클리어런스",
            rightIcon = true,
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
            titleColor = MDSColor.Black,
            textStyle = MaterialTheme.typography.titleLarge,
        )
    }
}
