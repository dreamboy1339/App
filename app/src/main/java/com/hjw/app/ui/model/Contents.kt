package com.hjw.app.ui.model

import com.hjw.app.ui.common.ContentType

interface Content

class Contents(private val data: List<Content>) : List<Content> by data {
    val type: ContentType
        get() = ContentType.NONE
}
