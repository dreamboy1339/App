package com.hjw.app.ui.main.content.scroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.hjw.app.R
import com.hjw.designsystem.component.content.MDSProduct
import com.hjw.domain.model.content.Goods

@Composable
fun ScrollView(
    goods: Goods,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
            .padding(bottom = dimensionResource(R.dimen.scroll_view_bottom_padding)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.scroll_view_horizontal_spacing)),
    ) {
        items(goods) { product ->
            MDSProduct(
                modifier = Modifier
                    .width(dimensionResource(R.dimen.product_width)),
                thumbnailUrl = product.thumbnailUrl,
                brandName = product.brandName,
                price = product.price,
                saleRate = product.saleRate,
                hasCoupon = product.hasCoupon
            )
        }
    }
}
