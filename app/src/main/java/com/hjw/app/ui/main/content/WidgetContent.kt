package com.hjw.app.ui.main.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.domain.common.ContentType
import com.hjw.domain.model.content.Banners
import com.hjw.domain.model.content.Contents
import com.hjw.domain.model.content.Goods
import com.hjw.domain.model.content.Styles

private const val TYPE_GRID_COLUMNS = 3
private const val TYPE_GRID_ROWS = 2

@Composable
fun WidgetContent(
    contents: Contents,
    modifier: Modifier = Modifier,
) {
    val contentType = contents.type
    val contentItems = contents.contentItems
    when (contentType) {
        ContentType.NONE -> {}
        ContentType.BANNER -> SwipeBannerPager(banners = contentItems as Banners)
        ContentType.GRID -> {
            GridView(
                modifier = modifier,
                goods = contentItems as Goods,
                columns = TYPE_GRID_COLUMNS,
                rows = TYPE_GRID_ROWS,
            )
        }

        ContentType.SCROLL -> {
            ScrollView(
                modifier = modifier,
                goods = contentItems as Goods
            )
        }

        ContentType.STYLE -> {
            StyleView(
                modifier = modifier,
                styles = contentItems as Styles
            )
        }
    }
}
