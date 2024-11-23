package com.hjw.data.widget.repository.widget

import com.hjw.data.widget.datasource.widget.WidgetRemoteDataSource
import com.hjw.data.widget.mapper.widget.toWidgets
import com.hjw.domain.common.ContentType
import com.hjw.domain.model.Content
import com.hjw.domain.model.Contents
import com.hjw.domain.model.Footer
import com.hjw.domain.model.Header
import com.hjw.domain.model.Widget
import com.hjw.domain.model.Widgets
import com.hjw.domain.model.content.Banner
import com.hjw.domain.model.content.Banners
import com.hjw.domain.model.content.Goods
import com.hjw.domain.model.content.Product
import com.hjw.domain.model.content.Style
import com.hjw.domain.model.content.Styles
import com.hjw.domain.repository.WidgetRepository
import com.hjw.network.model.ApiResponse
import com.hjw.network.model.BannerData
import com.hjw.network.model.ContentsData
import com.hjw.network.model.FooterData
import com.hjw.network.model.GoodsData
import com.hjw.network.model.HeaderData
import com.hjw.network.model.StyleData
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

        val apiResponse = response.body()
            ?: return@withContext Result.failure(Exception("response body is null"))

        Result.success(apiResponse.toWidgets())
    }
}
