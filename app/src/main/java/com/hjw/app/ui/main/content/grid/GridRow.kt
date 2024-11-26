package com.hjw.app.ui.main.content.grid

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.app.ui.main.content.calculateAvailableMaxRowCount
import com.hjw.app.ui.main.content.calculateItemPosition
import com.hjw.app.ui.main.content.isApplyItemPadding
import com.hjw.app.ui.main.content.isItemPositionAvailable
import com.hjw.designsystem.component.content.MDSProduct
import com.hjw.designsystem.theme.Spacing
import com.hjw.domain.model.content.Goods

@Composable
fun GridRow(
    columns: Int,
    row: Int,
    goods: Goods,
    onLoadMore: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 20.dp)
    ) {
        val totalCount = goods.size
        val maxRows = calculateAvailableMaxRowCount(totalCount, columns)

        for (column in 0 until columns) {
            val position = calculateItemPosition(
                row = row,
                column = column,
                columns = columns
            )

            val isPositionAvailable = isItemPositionAvailable(position, maxRows, columns)

            // 빈 포지션인 경우 빈 공간을 채운다.
            if (isPositionAvailable && position >= totalCount) {
                EmptyProduct(
                    modifier = Modifier
                        .weight(1f),
                )
                // 다음 포지션이 유효한지 확인한 후 더보기 동작 여부를 결정한다.
                val nextPosition = position + 1
                onLoadMore(isItemPositionAvailable(nextPosition, maxRows, columns))
                break
            }

            // 유효하지 않은 포지션인 경우 멈춘다.
            if (isPositionAvailable.not()) {
                break
            }

            val isItemPadding = isApplyItemPadding(
                position = position,
                columns = columns
            )

            if (isItemPadding) {
                Spacer(modifier = Modifier.size(Spacing.xxs))
            }

            val product = goods[position]
            MDSProduct(
                modifier = Modifier
                    .weight(1f),
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
