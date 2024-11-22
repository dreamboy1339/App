package com.hjw.data.widget

import com.hjw.domain.common.ContentType
import com.hjw.domain.model.Content
import com.hjw.domain.model.Contents
import com.hjw.domain.model.Footer
import com.hjw.domain.model.Header
import com.hjw.domain.model.Widget
import com.hjw.domain.model.Widgets
import com.hjw.domain.repository.WidgetRepository
import com.hjw.network.model.ApiResponse
import com.hjw.network.model.ContentsData
import com.hjw.network.model.FooterData
import com.hjw.network.model.HeaderData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WidgetRepositoryImpl @Inject constructor(
    private val dataSource: WidgetRemoteDataSource,
) : WidgetRepository {
    override suspend fun fetchWidgetList(): Result<Widgets> = withContext(Dispatchers.IO) {
        val response = dataSource.fetchWidgetList()

        if (response.isSuccessful.not()) {
            val exception = Exception("${response.code()}")
            return@withContext Result.failure(exception)
        }

        val apiResponse: ApiResponse = response.body()
            ?: throw Exception("response body is null")

        Result.success(apiResponse.toWidgets())
    }
}

private fun ApiResponse.toWidgets(): Widgets {
    val widgetList: List<Widget> = data.map { widgetData ->
        Widget(
            header = widgetData.headerData?.toHeader(),
            footer = widgetData.footerData?.toFooter(),
            contents = widgetData.contentsData.toContents(),
        )
    }
    return Widgets(widgetList = widgetList)
}

private fun ContentsData.toContents(): Contents {
    val contentType = ContentType.from(type = type)
    val contentList = when (contentType) {
        ContentType.NONE -> emptyList<Content>()
        ContentType.BANNER -> TODO()
        ContentType.GRID -> TODO()
        ContentType.SCROLL -> TODO()
        ContentType.STYLE -> TODO()
    }
    return Contents(
        contentList = contentList
    )
}

private fun FooterData.toFooter(): Footer {
    return Footer(
        type = type,
        title = title,
        iconUrl = iconUrl ?: "",
    )
}

private fun HeaderData.toHeader(): Header {
    return Header(
        title = title,
        iconUrl = iconUrl ?: "",
        linkUrl = linkUrl ?: "",
    )
}
