package com.hjw.app.ui.main.content.style

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.content.MDSProductImage
import com.hjw.domain.model.content.Style

@Composable
fun FirstStyleRow(
    styles: List<Style>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        MDSProductImage(
            modifier = Modifier
                .weight(2f)
                .padding(1.dp),
            thumbnailUrl = styles[0].thumbnailUrl,
            hasCoupon = false
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            MDSProductImage(
                modifier = Modifier
                    .padding(1.dp),
                thumbnailUrl = styles[1].thumbnailUrl,
                hasCoupon = false
            )
            MDSProductImage(
                modifier = Modifier
                    .padding(1.dp),
                thumbnailUrl = styles[2].thumbnailUrl,
                hasCoupon = false
            )
        }
    }
}
