package com.hjw.domain.model

data class Widget(
    val header: Header? = null,
    val footer: Footer? = null,
    val contents: Contents,
)

class Widgets(widgetList: List<Widget>) : List<Widget> by widgetList
