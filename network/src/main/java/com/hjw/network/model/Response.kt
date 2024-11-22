package com.hjw.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val data: List<Data>,
)

@Serializable
data class Data(
    val contentsData: ContentsData,
    val header: HeaderData? = null,
    val Footer: FooterData? = null,
)

@Serializable
data class ContentsData(
    val type: String,
    val banners: List<BannerData>? = null,
    val goods: List<ProductData>? = null,
    val styles: List<StyleData>? = null,
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
data class ProductData(
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
