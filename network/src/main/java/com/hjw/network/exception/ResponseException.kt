package com.hjw.network.exception

class ResponseException(
    val statusCode: Int,
    override val message: String = "statusCode: $statusCode",
) : Exception(message)
