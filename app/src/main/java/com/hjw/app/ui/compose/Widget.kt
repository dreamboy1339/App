package com.hjw.app.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.designsystem.component.footer.MDSFooter
import com.hjw.designsystem.component.header.MDSHeader
import com.hjw.domain.model.content.Content
import com.hjw.domain.model.Widget
import com.hjw.domain.model.content.Contents

@Composable
fun WidgetItem(
    widget: Widget,
    onFooterClick: () -> Unit,
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

    ContentBody(widget.contents)

    val footer = widget.footer
    if (footer != null) {
        MDSFooter(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            type = FooterType.safeValueOf(footer.type),
            title = footer.title,
            onClick = onFooterClick
        )
    }
}

@Composable
fun ContentBody(contents: Contents) {
    contents.forEach { content: Content ->

    }
}
