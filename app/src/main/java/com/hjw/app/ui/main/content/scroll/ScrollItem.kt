package com.hjw.app.ui.main.content.scroll

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hjw.app.ui.main.content.ScrollView
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.designsystem.component.footer.MDSFooter
import com.hjw.designsystem.component.header.MDSHeader
import com.hjw.domain.model.Widget
import com.hjw.domain.model.content.Content
import com.hjw.domain.model.content.Goods

@Composable
fun ScrollItem(
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

    var goods by remember { mutableStateOf(contentItems as Goods) }
    val onRefreshClick: () -> Unit = {
        // Refresh 가능한 상태일 때만 행을 추가한다.
        goods = Goods(goods.shuffled())
    }

    ScrollView(
        modifier = modifier,
        goods = goods
    )

    val footer = widget.footer
    if (footer != null) {
        val type = FooterType.safeValueOf(footer.type)
        MDSFooter(
            modifier = modifier,
            title = footer.title,
            showIcon = (type == FooterType.REFRESH),
            onClick = onRefreshClick
        )
    }
}
