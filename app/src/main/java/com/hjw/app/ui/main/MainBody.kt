package com.hjw.app.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.domain.model.Widgets

@Composable
fun MainBody(
    widgets: Widgets,
    modifier: Modifier = Modifier,
    onFooterClick: (FooterType) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        content = {
            itemsIndexed(
                items = widgets,
                key = { index, item -> "$index-${item.hashCode()}" }
            ) { _, widget ->
                WidgetItem(
                    widget = widget,
                    onFooterClick = onFooterClick
                )
            }
        }
    )
}

@Preview
@Composable
private fun MainBodyPreview() {
    AppPreview {
        MainBody(widgets = Widgets(listOf()))
    }
}
