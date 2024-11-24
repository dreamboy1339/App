package com.hjw.app.ui.main.content.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.app.ui.main.content.StyleView
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.designsystem.component.footer.MDSFooter
import com.hjw.designsystem.component.header.MDSHeader
import com.hjw.domain.model.Widget
import com.hjw.domain.model.content.Content
import com.hjw.domain.model.content.Styles

@Composable
fun StyleItem(
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
    StyleView(
        modifier = modifier,
        styles = contentItems as Styles
    )
    val footer = widget.footer
    if (footer != null) {
        val type = FooterType.safeValueOf(footer.type)
        MDSFooter(
            modifier = modifier,
            title = footer.title,
            showIcon = (type == FooterType.REFRESH),
            onClick = {

            }
        )
    }
}
