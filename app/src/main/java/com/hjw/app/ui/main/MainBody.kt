package com.hjw.app.ui.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.ui.main.content.WidgetItem
import com.hjw.designsystem.AppPreview
import com.hjw.domain.model.Widgets

@Composable
fun MainBody(
    widgets: Widgets,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        content = {
            itemsIndexed(
                items = widgets,
                key = { index, item -> "$index-${item.hashCode()}" }
            ) { _, widget ->
                WidgetItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    widget = widget,
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
