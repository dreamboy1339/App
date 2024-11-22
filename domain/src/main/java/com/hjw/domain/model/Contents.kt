package com.hjw.domain.model

interface Content

class Contents(contentList: List<Content>) : List<Content> by contentList
