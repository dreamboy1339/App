package com.hjw.app.ui.model

interface Content

class Contents(contentList: List<Content>) : List<Content> by contentList
