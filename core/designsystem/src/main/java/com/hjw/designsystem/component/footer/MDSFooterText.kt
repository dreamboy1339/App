package com.hjw.designsystem.component.footer

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
import com.hjw.designsystem.theme.Spacing

@Composable
fun MDSFooterText(
    textStyle: TextStyle,

    title: String = "",
    titleColor: Color = MaterialTheme.colorScheme.primary,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Refresh"
        )

        Spacer(modifier = Modifier.size(Spacing.xs))

        Text(
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = textStyle,
            color = titleColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MDSFooterTextWithLeftIconPreview() {
    AppPreview {
        MDSFooterText(
            title = "클리어런스",
            titleColor = MDSColor.Black,
            textStyle = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MDSFooterTextWithRightIconPreview() {
    AppPreview {
        MDSFooterText(
            title = "클리어런스",
            titleColor = MDSColor.Black,
            textStyle = MaterialTheme.typography.titleLarge,
        )
    }
}
