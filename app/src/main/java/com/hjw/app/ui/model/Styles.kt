package com.hjw.app.ui.model

data class Style(
    val linkUrl: String,
    val thumbnailUrl: String,
) : Content

class Styles(styleList: List<Styles>) : List<Styles> by styleList
