package com.hjw.app.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.footer.Footer
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.designsystem.component.header.Header
import com.hjw.domain.model.Content
import com.hjw.domain.model.Widget

@Composable
fun Widget(
    widget: Widget,
    onFooterClick: () -> Unit,
) {
    val header = widget.header
    if (header != null) {
        Header(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            title = header.title,
            iconUrl = header.iconUrl,
            linkUrl = header.linkUrl
        )
    }

    Contents(widget.contents)

    val footer = widget.footer
    if (footer != null) {
        Footer(
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
fun Contents(contents: com.hjw.domain.model.Contents) {
    contents.forEach { content: Content ->

    }
}
