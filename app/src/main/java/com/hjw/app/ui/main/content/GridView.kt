package com.hjw.app.ui.main.content

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.content.MDSProduct
import com.hjw.designsystem.theme.MDSColor
import com.hjw.domain.model.content.Goods

@Composable
fun GridView(
    goods: Goods,
    modifier: Modifier = Modifier,
    columns: Int = 3,
    rows: Int = 2,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        for (row in 0 until rows) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                for (column in 0 until columns) {
                    val position = calculateProductPosition(row, columns, column)
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
                }
            }
        }
    }
}

@Composable
private fun calculateProductPosition(row: Int, columns: Int, column: Int) = row * columns + column
