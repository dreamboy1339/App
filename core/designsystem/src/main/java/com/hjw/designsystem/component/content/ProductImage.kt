package com.hjw.designsystem.component.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.theme.MDSColor

@Composable
fun MDSProductImage(
    thumbnailUrl: String,
    hasCoupon: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .aspectRatio(0.8f)
    ) {
        AsyncImage(
            contentScale = ContentScale.FillHeight,
            model = thumbnailUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
        )
        if (hasCoupon) {
            Coupon(
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )
        }
    }
}

@Composable
private fun Coupon(modifier: Modifier) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .background(MDSColor.Blue)
            .padding(4.dp)
    ) {
        Text(
            text = "쿠폰",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductImageWithCouponPreview() {
    AppPreview {
        MDSProductImage(
            thumbnailUrl = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
            hasCoupon = true,
            modifier = Modifier.width(150.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductImageWithNoCouponPreview() {
    AppPreview {
        MDSProductImage(
            thumbnailUrl = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
            hasCoupon = false,
            modifier = Modifier.width(150.dp)
        )
    }
}
