package com.hjw.designsystem.component.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.common.decimalFormat
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.R
import com.hjw.designsystem.theme.Orange

@Composable
fun Product(
    linkUrl: String,
    thumbnailUrl: String,
    brandName: String,
    price: Int,
    saleRate: Int,
    hasCoupon: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        ProductImage(
            modifier = modifier,
            thumbnailUrl = thumbnailUrl,
            brandName = brandName,
            hasCoupon = hasCoupon
        )
        ProductInfo(
            modifier = modifier,
            brandName = brandName,
            price = price,
            saleRate = saleRate
        )
    }
}

@Composable
private fun ProductInfo(
    brandName: String,
    price: Int,
    saleRate: Int,
    modifier: Modifier,
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = brandName,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.tertiary
    )

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringPrice(price),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringSaleRate(saleRate),
            style = MaterialTheme.typography.labelSmall,
            color = Orange
        )
    }
}

@Composable
private fun stringPrice(price: Int) = stringResource(R.string.txt_price_won, price.decimalFormat())

@Composable
private fun stringSaleRate(saleRate: Int) = stringResource(R.string.txt_sale_rate, saleRate)

@Preview(showBackground = true)
@Composable
private fun ProductPreview() {
    AppPreview {
        Product(
            linkUrl = "https://www.musinsa.com/app/goods/2281818",
            thumbnailUrl = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
            brandName = "아스트랄 프로젝션 아스트랄 프로젝션 아스트랄 프로젝션",
            price = 39900,
            saleRate = 50,
            hasCoupon = true,
            modifier = Modifier.width(150.dp)
        )
    }
}
