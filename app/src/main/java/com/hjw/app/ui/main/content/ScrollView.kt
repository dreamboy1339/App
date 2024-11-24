package com.hjw.app.ui.main.content

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.content.MDSProduct
import com.hjw.designsystem.theme.MDSColor
import com.hjw.domain.model.content.Goods

@Composable
fun ScrollView(
    goods: Goods,
    modifier: Modifier = Modifier,
) {
    LazyHorizontalGrid(
        modifier = modifier
            .height(500.dp),
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(goods) { product ->
            MDSProduct(
                modifier = Modifier
                    .width(150.dp)
                    .border(1.dp, color = MDSColor.Orange), // test
                linkUrl = product.linkUrl,
                thumbnailUrl = product.thumbnailUrl,
                brandName = product.brandName,
                price = product.price,
                saleRate = product.saleRate,
                hasCoupon = product.hasCoupon
            )
        }
    }
}
