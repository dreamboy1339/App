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
import com.hjw.domain.model.content.Styles

@Composable
fun StyleView(
    styles: Styles,
    modifier: Modifier = Modifier,
    columns: Int = 3,
    rows: Int = 3,
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
                    val position = calculateGridPosition(row, columns, column)
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
    }
}

@Composable
private fun calculateGridPosition(row: Int, columns: Int, column: Int) = row * columns + column
