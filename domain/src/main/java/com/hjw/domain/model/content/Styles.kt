package com.hjw.domain.model.content

data class Style(
    val linkUrl: String,
    val thumbnailUrl: String,
) : Content

class Styles(styleList: List<Style>) : List<Style> by styleList
