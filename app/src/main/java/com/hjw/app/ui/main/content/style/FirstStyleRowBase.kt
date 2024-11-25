package com.hjw.app.ui.main.content.style

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.hjw.app.R
import com.hjw.designsystem.component.content.MDSProductImage
import com.hjw.domain.model.content.Styles

@Composable
fun FirstStyleRowBase(
    styles: Styles,
    modifier: Modifier = Modifier,
) {
    val thumbnailUrls = styles.map { it.thumbnailUrl }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        MDSProductImage(
            modifier = Modifier
                .weight(2f)
                .padding(dimensionResource(R.dimen.product_padding)),
            thumbnailUrl = thumbnailUrls[0],
            hasCoupon = false
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            MDSProductImage(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.product_padding)),
                thumbnailUrl = thumbnailUrls[1],
                hasCoupon = false
            )
            MDSProductImage(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.product_padding)),
                thumbnailUrl = thumbnailUrls[2],
                hasCoupon = false
            )
        }
    }
}
