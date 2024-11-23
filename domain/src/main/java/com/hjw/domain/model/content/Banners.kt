package com.hjw.domain.model.content

data class Banner(
    val linkUrl: String,
    val thumbnailUrl: String,
    val title: String,
    val description: String,
    val keyword: String,
): Content

class Banners(bannerList: List<Banner>) : List<Banner> by bannerList
