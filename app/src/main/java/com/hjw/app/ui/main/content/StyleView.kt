package com.hjw.app.ui.main.content

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.content.MDSProductImage
import com.hjw.designsystem.theme.MDSColor
import com.hjw.domain.model.content.Style
import com.hjw.domain.model.content.Styles

@Composable
fun StyleView(
    styles: Styles,
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
            if (row == 0) {
                FirstStyleRow(styles.subList(0, 3))
            } else {
                StyleRow(columns, row, styles)
            }
        }
    }
}

@Composable
private fun StyleRow(
    columns: Int,
    row: Int,
    styles: Styles,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        for (column in 0 until columns) {
            val position = calculateStylePosition(row, columns, column)
            val product = styles[position]
            MDSProductImage(
                modifier = Modifier
                    .weight(1f)
                    .padding(1.dp)
                    .border(width = 1.dp, color = MDSColor.Orange),
                thumbnailUrl = product.thumbnailUrl,
                hasCoupon = false
            )
        }
    }
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

@Composable
private fun calculateStylePosition(row: Int, columns: Int, column: Int) = row * columns + column
