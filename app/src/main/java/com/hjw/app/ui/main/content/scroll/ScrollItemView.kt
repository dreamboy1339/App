package com.hjw.app.ui.main.content.scroll

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hjw.designsystem.component.footer.MDSFooter
import com.hjw.designsystem.component.header.MDSHeader
import com.hjw.domain.model.Widget
import com.hjw.domain.model.content.Content
import com.hjw.domain.model.content.Goods

@Composable
fun ScrollItemView(
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
        goods = Goods(goods.shuffled())
    }

    ScrollView(
        modifier = modifier,
        goods = goods
    )

    val footer = widget.footer
    if (footer != null) {
        MDSFooter(
            title = footer.title,
            modifier = modifier,
            onClick = onRefreshClick,
            iconUrl = footer.iconUrl
        )
    }
}
