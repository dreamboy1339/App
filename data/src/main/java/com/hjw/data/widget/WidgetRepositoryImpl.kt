package com.hjw.data.widget

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
import com.hjw.domain.repository.WidgetRepository
import com.hjw.network.model.ApiResponse
import com.hjw.network.model.BannerData
import com.hjw.network.model.ContentsData
import com.hjw.network.model.FooterData
import com.hjw.network.model.GoodsData
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
    val contentList: List<Content> = when (contentType) {
        ContentType.NONE -> emptyList()
        ContentType.BANNER -> bannerDatas?.toBanners() ?: emptyList()
        ContentType.GRID,
        ContentType.SCROLL,
            -> goodsDatas?.toGoods() ?: emptyList()

        ContentType.STYLE -> TODO()
    }
    return Contents(
        contentList = contentList
    )
}

private fun List<GoodsData>.toGoods(): Goods {
    return Goods(
        productList = map {
            Product(
                linkUrl = it.linkUrl,
                thumbnailUrl = it.thumbnailUrl,
                brandName = it.brandName,
                price = it.price,
                saleRate = it.saleRate,
                hasCoupon = it.hasCoupon
            )
        }
    )
}

fun List<BannerData>.toBanners(): Banners {
    return Banners(
        bannerList = map {
            Banner(
                linkUrl = it.linkUrl,
                thumbnailUrl = it.thumbnailUrl,
                title = it.title,
                description = it.description,
                keyword = it.keyword,
            )
        }
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
