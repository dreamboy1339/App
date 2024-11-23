package com.hjw.domain.model.content

import com.hjw.domain.common.ContentType

sealed interface Content

data class Contents(val type: ContentType, val contentItems: List<Content>)
