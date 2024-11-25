package com.hjw.designsystem.component.footer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.theme.MDSColor

@Composable
fun MDSFooter(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    iconUrl: String,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MDSColor.White,
            contentColor = MDSColor.Gray
        ),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MDSColor.Gray
        ),
        onClick = onClick
    ) {
        MDSFooterText(
            title = title,
            titleColor = MDSColor.Black,
            modifier = Modifier.wrapContentSize(),
            textStyle = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
            iconUrl = iconUrl
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FooterRefreshPreview() {
    AppPreview {
        MDSFooter(
            title = "새로운 추천",
            modifier = Modifier.fillMaxWidth(),
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FooterMorePreview() {
    AppPreview {
        MDSFooter(
            title = "더보기",
            modifier = Modifier.fillMaxWidth(),
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png"
        )
    }
}
