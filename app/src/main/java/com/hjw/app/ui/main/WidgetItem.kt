package com.hjw.app.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.app.ui.main.content.WidgetContent
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.designsystem.component.footer.MDSFooter
import com.hjw.designsystem.component.header.MDSHeader
import com.hjw.domain.model.Widget

@Composable
fun WidgetItem(
    widget: Widget,
    onFooterClick: (FooterType) -> Unit,
) {
    val header = widget.header
    if (header != null) {
        MDSHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            title = header.title,
            iconUrl = header.iconUrl,
            linkUrl = header.linkUrl
        )
    }

    WidgetContent(widget.contents)

    val footer = widget.footer
    if (footer != null) {
        val type = FooterType.safeValueOf(footer.type)
        MDSFooter(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            title = footer.title,
            showIcon = (type == FooterType.REFRESH),
            onClick = {
                onFooterClick(type)
            }
        )
    }
}
