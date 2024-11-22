package com.hjw.domain.common

enum class ContentType {
    NONE,
    BANNER,
    GRID,
    SCROLL,
    STYLE
    ;

    companion object {
        fun from(type: String): ContentType {
            return entries
                .find { contentType ->
                    contentType.name.equals(other = type, ignoreCase = true)
                }
                ?: NONE
        }
    }
}
