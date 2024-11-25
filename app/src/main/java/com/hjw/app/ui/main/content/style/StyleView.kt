package com.hjw.app.ui.main.content.style

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
