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
import com.hjw.designsystem.component.MDSIconText
import com.hjw.designsystem.theme.MDSColor

@Composable
fun MDSFooter(
    showIcon: Boolean,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
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
        MDSIconText(
            leftIcon = showIcon,
            title = title,
            titleColor = MDSColor.Black,
            modifier = Modifier.wrapContentSize(),
            textStyle = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FooterRefreshPreview() {
    AppPreview {
        MDSFooter(
            showIcon = true,
            title = "새로운 추천",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FooterMorePreview() {
    AppPreview {
        MDSFooter(
            showIcon = false,
            title = "더보기",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
