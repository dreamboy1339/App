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
import com.hjw.app.ui.common.calculateAvailableMaxRowCount
import com.hjw.app.ui.common.isApplyItemPadding
import com.hjw.app.ui.common.calculateItemPosition
import com.hjw.app.ui.common.isItemPositionAvailable
import com.hjw.designsystem.component.content.MDSProductImage
import com.hjw.designsystem.theme.MDSColor
import com.hjw.designsystem.theme.Spacing
import com.hjw.domain.model.content.Style
import com.hjw.domain.model.content.Styles

@Composable
fun StyleView(
    styles: Styles,
    modifier: Modifier = Modifier,
    columns: Int = 3,
    rows: Int = 2,
    onLoadMore: (Boolean) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        for (row in 0 until rows) {
            if (row == 0) {
                FirstStyleRow(styles.subList(0, 3))
            } else {
                StyleRow(
                    columns = columns,
                    row = row,
                    styles = styles,
                    onLoadMore = onLoadMore
                )
            }
        }
    }
}

@Composable
private fun StyleRow(
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
                        .padding(1.dp)
                        .border(width = 1.dp, color = MDSColor.Orange)
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

            val product = styles[position]
            MDSProductImage(
                modifier = Modifier
                    .weight(1f)
                    .padding(1.dp)
                    .border(width = 1.dp, color = MDSColor.Orange),
                thumbnailUrl = product.thumbnailUrl,
                hasCoupon = false
            )

            if (isItemPadding) {
                Spacer(modifier = Modifier.size(Spacing.xxs))
            }
        }
    }
}

@Composable
private fun EmptyProductImage(modifier: Modifier) {
    MDSProductImage(
        modifier = modifier,
        thumbnailUrl = "",
        hasCoupon = false
    )
}

@Composable
private fun FirstStyleRow(
    styles: List<Style>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        MDSProductImage(
            modifier = Modifier
                .weight(2f)
                .padding(1.dp)
                .border(width = 1.dp, color = MDSColor.Orange), // test
            thumbnailUrl = styles[0].thumbnailUrl,
            hasCoupon = false
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            MDSProductImage(
                modifier = Modifier
                    .padding(1.dp)
                    .border(width = 1.dp, color = MDSColor.Orange), // test
                thumbnailUrl = styles[1].thumbnailUrl,
                hasCoupon = false
            )
            MDSProductImage(
                modifier = Modifier
                    .padding(1.dp)
                    .border(width = 1.dp, color = MDSColor.Orange), // test
                thumbnailUrl = styles[2].thumbnailUrl,
                hasCoupon = false
            )
        }
    }
}
