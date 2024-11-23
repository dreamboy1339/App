package com.hjw.data.widget.mapper.widget

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
import com.hjw.network.model.ApiResponse
import com.hjw.network.model.BannerData
import com.hjw.network.model.ContentsData
import com.hjw.network.model.FooterData
import com.hjw.network.model.GoodsData
import com.hjw.network.model.HeaderData
import com.hjw.network.model.StyleData

internal fun ApiResponse.toEntity(): Widgets {
    val widgetList: List<Widget> = data.map { widgetData ->
        Widget(
            header = widgetData.headerData?.toHeader(),
            footer = widgetData.footerData?.toFooter(),
            contents = widgetData.contentsData.toContents(),
        )
    }
    return Widgets(widgetList = widgetList)
}

internal fun ContentsData.toContents(): Contents {
    val contentType = ContentType.from(type = type)
    val contentList: List<Content> = when (contentType) {
        ContentType.NONE -> emptyList()
        ContentType.BANNER -> bannerDatas?.toBanners() ?: emptyList()
        ContentType.GRID,
        ContentType.SCROLL,
            -> goodsDatas?.toGoods() ?: emptyList()

        ContentType.STYLE -> styleDatas?.toStyles() ?: emptyList()
    }
    return Contents(
        contentList = contentList
    )
}

internal fun List<StyleData>.toStyles(): Styles {
    return Styles(
        styleList = map { styleData ->
            Style(
                linkUrl = styleData.linkUrl,
                thumbnailUrl = styleData.thumbnailUrl,
            )
        }
    )
}

internal fun List<GoodsData>.toGoods(): Goods {
    return Goods(
        productList = map { goodsData ->
            Product(
                linkUrl = goodsData.linkUrl,
                thumbnailUrl = goodsData.thumbnailUrl,
                brandName = goodsData.brandName,
                price = goodsData.price,
                saleRate = goodsData.saleRate,
                hasCoupon = goodsData.hasCoupon
            )
        }
    )
}

fun List<BannerData>.toBanners(): Banners {
    return Banners(
        bannerList = map { bannerData ->
            Banner(
                linkUrl = bannerData.linkUrl,
                thumbnailUrl = bannerData.thumbnailUrl,
                title = bannerData.title,
                description = bannerData.description,
                keyword = bannerData.keyword,
            )
        }
    )
}

internal fun FooterData.toFooter(): Footer {
    return Footer(
        type = type,
        title = title,
        iconUrl = iconUrl ?: "",
    )
}

internal fun HeaderData.toHeader(): Header {
    return Header(
        title = title,
        iconUrl = iconUrl ?: "",
        linkUrl = linkUrl ?: "",
    )
}
