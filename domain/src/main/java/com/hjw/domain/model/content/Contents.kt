package com.hjw.domain.model.content

sealed interface Content

class Contents(contentList: List<Content>) : List<Content> by contentList
