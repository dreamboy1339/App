package com.hjw.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val data: List<Data>,
)

@Serializable
data class Data(
    @SerialName("contents") val contentsData: ContentsData,
    @SerialName("header") val headerData: HeaderData? = null,
    @SerialName("footer") val footerData: FooterData? = null,
)

@Serializable
data class ContentsData(
    val type: String,
    @SerialName("banners") val bannerDatas: List<BannerData>? = null,
    @SerialName("goods") val goodsDatas: List<GoodsData>? = null,
    @SerialName("styles") val styleDatas: List<StyleData>? = null,
)

@Serializable
data class BannerData(
    @SerialName("linkURL") val linkUrl: String,
    @SerialName("thumbnailURL") val thumbnailUrl: String,
    val title: String,
    val description: String,
    val keyword: String,
)

@Serializable
data class GoodsData(
    @SerialName("linkURL") val linkUrl: String,
    @SerialName("thumbnailURL") val thumbnailUrl: String,
    @SerialName("brandName") val brandName: String,
    val price: Int,
    @SerialName("saleRate") val saleRate: Int,
    @SerialName("hasCoupon") val hasCoupon: Boolean,
)

@Serializable
data class StyleData(
    @SerialName("linkURL") val linkUrl: String,
    @SerialName("thumbnailURL") val thumbnailUrl: String,
)

@Serializable
data class HeaderData(
    val title: String,
    @SerialName("iconURL") val iconUrl: String? = null,
    @SerialName("linkURL") val linkUrl: String? = null,
)

@Serializable
data class FooterData(
    val type: String,
    val title: String,
    @SerialName("iconURL") val iconUrl: String? = null,
)
