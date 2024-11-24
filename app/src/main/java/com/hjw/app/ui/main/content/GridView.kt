package com.hjw.app.ui.main.content

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.content.MDSProduct
import com.hjw.designsystem.theme.MDSColor
import com.hjw.designsystem.theme.Spacing
import com.hjw.domain.model.content.Goods

@Composable
fun GridView(
    goods: Goods,
    columns: Int,
    rows: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        for (row in 0 until rows) {
            GridRow(
                columns = columns,
                row = row,
                goods = goods
            )
        }
    }
}

@Composable
private fun GridRow(
    columns: Int,
    row: Int,
    goods: Goods,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 20.dp)
    ) {
        for (column in 0 until columns) {
            val position = calculateProductPosition(
                row = row,
                column = column,
                columns = columns
            )

            val isItemPadding = calculateItemPadding(
                position = position,
                columns = columns
            )
            if (isItemPadding) {
                Spacer(modifier = Modifier.size(Spacing.xxs))
            }

            val product = goods[position]
            MDSProduct(
                modifier = Modifier
                    .weight(1f)
                    .border(width = 1.dp, color = MDSColor.Orange),
                linkUrl = product.linkUrl,
                thumbnailUrl = product.thumbnailUrl,
                brandName = product.brandName,
                price = product.price,
                saleRate = product.saleRate,
                hasCoupon = product.hasCoupon
            )

            if (isItemPadding) {
                Spacer(modifier = Modifier.size(Spacing.xxs))
            }
        }
    }
}

@Composable
private fun calculateItemPadding(position: Int, columns: Int): Boolean = position % columns == 1

@Composable
private fun calculateProductPosition(row: Int, column: Int, columns: Int) = row * columns + column
