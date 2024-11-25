package com.hjw.app.ui.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.ui.main.content.banner.BannerItem
import com.hjw.app.ui.main.content.grid.GridItem
import com.hjw.app.ui.main.content.scroll.ScrollItem
import com.hjw.app.ui.main.content.style.StyleItem
import com.hjw.designsystem.AppPreview
import com.hjw.domain.common.ContentType
import com.hjw.domain.model.Widgets
import com.hjw.domain.model.content.Banners

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
                val contents = widget.contents
                val contentType = contents.type
                val contentItems = contents.contentItems

                when (contentType) {
                    ContentType.NONE -> {}
                    ContentType.BANNER -> {
                        BannerItem(
                            banners = contentItems as Banners
                        )
                    }

                    ContentType.GRID -> {
                        GridItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp),
                            widget = widget,
                            contentItems = contentItems
                        )
                    }

                    ContentType.SCROLL -> {
                        ScrollItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp),
                            widget = widget,
                            contentItems = contentItems
                        )
                    }

                    ContentType.STYLE -> {
                        StyleItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp),
                            widget = widget,
                            contentItems = contentItems
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.size(18.dp))
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
