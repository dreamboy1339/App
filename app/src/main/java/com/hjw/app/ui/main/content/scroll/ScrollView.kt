package com.hjw.app.ui.main.content.scroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.hjw.app.R
import com.hjw.designsystem.component.content.MDSProduct
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
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.scroll_view_horizontal_spacing)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.scroll_view_vertical_spacing))
    ) {
        items(goods) { product ->
            MDSProduct(
                modifier = Modifier
                    .width(dimensionResource(R.dimen.product_width)),
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
