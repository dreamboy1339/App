package com.hjw.designsystem.component.header

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.theme.MDSColor

@Composable
fun MDSHeader(
    title: String,
    modifier: Modifier = Modifier,
    iconUrl: String = "",
    linkUrl: String = "",
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MDSHeaderTitle(
            title = title,
            iconUrl = iconUrl,
            modifier = Modifier.weight(1f),
            textStyle = MaterialTheme.typography.titleLarge,
        )

        if (linkUrl.isNotBlank()) {
            Text(
                text = "전체",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderWithNoParamsPreview() {
    AppPreview {
        MDSHeader(title = "클리어런스")
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderWithLinkUrlPreview() {
    AppPreview {
        MDSHeader(
            title = "클리어런스",
            linkUrl = "https://www.musinsa.com/brands/discoveryexpedition?category3DepthCodes=&category2DepthCodes=&category1DepthCode=018&colorCodes=&startPrice=&endPrice=&exclusiveYn=&includeSoldOut=&saleGoods=&timeSale=&includeKeywords=&sortCode=discount_rate&tags=&page=1&size=90&listViewType=small&campaignCode=&groupSale=&outletGoods=false&boutiqueGoods="
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderWithIconUrlPreview() {
    AppPreview {
        MDSHeader(
            title = "클리어런스",
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderWithAllParamsPreview() {
    AppPreview {
        MDSHeader(
            title = "클리어런스클리어런스클리어런스클리어런스",
            iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
            linkUrl = "https://www.musinsa.com/brands/discoveryexpedition?category3DepthCodes=&category2DepthCodes=&category1DepthCode=018&colorCodes=&startPrice=&endPrice=&exclusiveYn=&includeSoldOut=&saleGoods=&timeSale=&includeKeywords=&sortCode=discount_rate&tags=&page=1&size=90&listViewType=small&campaignCode=&groupSale=&outletGoods=false&boutiqueGoods="
        )
    }
}
