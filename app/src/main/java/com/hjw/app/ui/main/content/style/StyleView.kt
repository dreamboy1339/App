package com.hjw.app.ui.main.content.style

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.domain.model.content.Styles

private const val STYLE_COLUMN_COUNT = 3

@Composable
fun StyleView(
    styles: Styles,
    rows: Int,
    columns: Int = STYLE_COLUMN_COUNT,
    onLoadMore: (Boolean) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    if (styles.checkFirstRowAvailable().not()) {
        return
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        for (row in 0 until rows) {
            StyleRowBases(row, styles, columns, onLoadMore)
        }
    }
}

@Composable
private fun StyleRowBases(
    row: Int,
    styles: Styles,
    columns: Int,
    onLoadMore: (Boolean) -> Unit,
) {
    when (row) {
        0 -> FirstStyleRowBase(styles = styles.fetchFirstRowStyles())
        else -> {
            StyleRowBase(
                columns = columns,
                row = row,
                styles = styles,
                onLoadMore = onLoadMore
            )
        }
    }
}
