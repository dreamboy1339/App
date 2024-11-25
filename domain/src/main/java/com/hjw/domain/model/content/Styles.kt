package com.hjw.domain.model.content

data class Style(
    val linkUrl: String,
    val thumbnailUrl: String,
) : Content


class Styles(styleList: List<Style>) : List<Style> by styleList {

    fun fetchFirstRowStyles(): Styles {
        if (size < STYLE_COLUMN_COUNT) {
            return Styles(emptyList())
        }
        return Styles(subList(0, STYLE_COLUMN_COUNT))
    }

    companion object {
        private const val STYLE_COLUMN_COUNT = 3
    }
}
