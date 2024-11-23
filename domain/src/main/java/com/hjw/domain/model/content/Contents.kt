package com.hjw.domain.model.content

import com.hjw.domain.common.ContentType

sealed interface Content

class Contents(val type: ContentType, contentList: List<Content>) : List<Content> by contentList
