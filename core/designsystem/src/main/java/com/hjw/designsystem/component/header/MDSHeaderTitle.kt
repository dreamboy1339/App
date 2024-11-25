package com.hjw.designsystem.component.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import com.hjw.designsystem.component.MDSImageIcon
import com.hjw.designsystem.theme.MDSColor
import com.hjw.designsystem.theme.Spacing

@Composable
fun MDSHeaderTitle(
    textStyle: TextStyle,
    title: String = "",
    iconUrl: String = "",
    titleColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .weight(weight = 0.7f, fill = false),
            text = title,
            overflow = TextOverflow.Ellipsis,
            style = textStyle,
            color = titleColor,
        )

        if (iconUrl.isNotBlank()) {
            Spacer(modifier = Modifier.size(Spacing.xs))
            MDSImageIcon(
                iconUrl = iconUrl
            )
            Spacer(modifier = Modifier.size(Spacing.xs))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MDSHeaderTitleWithLeftIconPreview() {
    AppPreview {
        MDSHeaderTitle(
            title = "클리어런스",
            titleColor = MDSColor.Black,
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MDSHeaderTitleWithRightIconPreview() {
    AppPreview {
        MDSHeaderTitle(
            title = "클리어런스",
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
            titleColor = MDSColor.Black,
            textStyle = MaterialTheme.typography.titleLarge,
        )
    }
}
