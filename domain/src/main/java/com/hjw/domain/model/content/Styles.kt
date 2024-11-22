package com.hjw.domain.model.content

import com.hjw.domain.model.Content

data class Style(
    val linkUrl: String,
    val thumbnailUrl: String,
) : Content

class Styles(styleList: List<Styles>) : List<Styles> by styleList
