package com.hjw.app.ui.main.content.style

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hjw.designsystem.component.footer.MDSFooter
import com.hjw.designsystem.component.header.MDSHeader
import com.hjw.domain.model.Widget
import com.hjw.domain.model.content.Content
import com.hjw.domain.model.content.Styles

private const val INIT_STYLE_ROW_COUNT = 2

@Composable
fun StyleItemView(
    widget: Widget,
    modifier: Modifier,
    contentItems: List<Content>,
) {
    val header = widget.header
    if (header != null) {
        MDSHeader(
            modifier = modifier,
            title = header.title,
            iconUrl = header.iconUrl,
            linkUrl = header.linkUrl
        )
    }

    var isLoadMore by rememberSaveable { mutableStateOf(true) }
    val onLoadMore: (Boolean) -> Unit = {
        isLoadMore = it
    }

    var rows by rememberSaveable { mutableIntStateOf(INIT_STYLE_ROW_COUNT) }
    val onMoreClick: () -> Unit = {
        // 더보기 가능한 상태일 때만 행을 추가한다.
        if (isLoadMore) {
            rows++
        }
    }

    StyleView(
        modifier = modifier,
        styles = contentItems as Styles,
        rows = rows,
        onLoadMore = onLoadMore
    )

    val footer = widget.footer
    if (footer != null && isLoadMore) {
        MDSFooter(
            title = footer.title,
            modifier = modifier,
            onClick = onMoreClick,
            iconUrl = footer.iconUrl
        )
    }
}
