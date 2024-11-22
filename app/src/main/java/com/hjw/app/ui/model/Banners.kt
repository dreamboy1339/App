package com.hjw.app.ui.model

data class Banner(
    val linkURL: String,
    val thumbnailURL: String,
    val title: String,
    val description: String,
    val keyword: String,
):Content

class Banners(private val bannerList: List<Banner>) : List<Banner> by bannerList
