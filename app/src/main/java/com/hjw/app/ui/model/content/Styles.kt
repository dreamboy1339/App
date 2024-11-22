package com.hjw.app.ui.model.content

import com.hjw.app.ui.model.Content

data class Style(
    val linkUrl: String,
    val thumbnailUrl: String,
) : Content

class Styles(styleList: List<Styles>) : List<Styles> by styleList
