package com.hjw.domain.common

sealed interface WidgetError : Error {

    enum class Network : WidgetError {
        EMPTY_RESPONSE,
        UNKNOWN
        ;
    }

    data class GenericError(val throwable: Throwable) : WidgetError
    data class HttpClientError(val status: String) : WidgetError
    data class ServerError(val message: String) : WidgetError
}
