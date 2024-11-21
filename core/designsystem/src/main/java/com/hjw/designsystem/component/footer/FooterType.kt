package com.hjw.designsystem.component.footer

enum class FooterType {
    NONE,
    REFRESH,
    MORE
    ;

    companion object {
        fun safeValueOf(type: String): FooterType {
            return entries
                .find {
                    it.name.equals(type, ignoreCase = true)
                }
                ?: NONE
        }
    }
}
