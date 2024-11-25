package com.hjw.app.ui.main.content.grid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.domain.model.content.Goods

private const val GRID_COLUMN_COUNT = 3
private const val INIT_GRID_ROW_COUNT = 2

@Composable
fun GridView(
    goods: Goods,
    columns: Int = GRID_COLUMN_COUNT,
    rows: Int = INIT_GRID_ROW_COUNT,
    modifier: Modifier = Modifier,
    onLoadMore: (Boolean) -> Unit,
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
                goods = goods,
                onLoadMore = onLoadMore
            )
        }
    }
}
