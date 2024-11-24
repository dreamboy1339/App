package com.hjw.app.ui.main.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.designsystem.component.footer.MDSFooter
import com.hjw.designsystem.component.header.MDSHeader
import com.hjw.domain.model.Widget

@Composable
fun WidgetItem(
    widget: Widget,
    modifier: Modifier = Modifier,
    onFooterClick: (FooterType) -> Unit,
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

    WidgetContent(
        modifier = modifier,
        contents = widget.contents
    )

    val footer = widget.footer
    if (footer != null) {
        val type = FooterType.safeValueOf(footer.type)
        MDSFooter(
            modifier = modifier,
            title = footer.title,
            showIcon = (type == FooterType.REFRESH),
            onClick = {
                onFooterClick(type)
            }
        )
    }
}
