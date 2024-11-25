package com.hjw.app.ui.main.content.style

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.hjw.app.R
import com.hjw.app.ui.main.content.calculateAvailableMaxRowCount
import com.hjw.app.ui.main.content.calculateItemPosition
import com.hjw.app.ui.main.content.isApplyItemPadding
import com.hjw.app.ui.main.content.isItemPositionAvailable
import com.hjw.designsystem.component.content.MDSProductImage
import com.hjw.designsystem.theme.Spacing
import com.hjw.domain.model.content.Styles

@Composable
fun StyleRowBase(
    columns: Int,
    row: Int,
    styles: Styles,
    onLoadMore: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val totalCount = styles.size
        val maxRows = calculateAvailableMaxRowCount(totalCount, columns)

        for (column in 0 until columns) {
            val position = calculateItemPosition(
                row = row,
                columns = columns,
                column = column
            )

            val isPositionAvailable = isItemPositionAvailable(position, maxRows, columns)

            // 빈 포지션인 경우 빈 공간을 채운다.
            if (isPositionAvailable && position >= totalCount) {
                EmptyProductImage(
                    modifier = Modifier
                        .weight(1f)
                        .padding(dimensionResource(R.dimen.product_padding)),
                )
                // 다음 포지션이 유효한지 확인한 후 더보기 동작 여부를 결정한다.
                val nextPosition = position.inc()
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

            val product = styles[position]
            MDSProductImage(
                modifier = Modifier
                    .weight(1f)
                    .padding(1.dp),
                thumbnailUrl = product.thumbnailUrl,
                hasCoupon = false
            )

            if (isItemPadding) {
                Spacer(modifier = Modifier.size(Spacing.xxs))
            }
        }
    }
}
