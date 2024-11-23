package com.hjw.network.common

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject


object ErrorBodyParser {

    private const val EMPTY_ERROR_BODY = ""
    private const val KEY_ERROR_CODE = "code"
    private const val KEY_ERRORS = "errors"

    val json = Json {
        ignoreUnknownKeys = true
    }

    fun parse(errorBodyString: String?): String {
        if (errorBodyString.isNullOrBlank()) return EMPTY_ERROR_BODY

        runCatching {
            val jsonElement = json.parseToJsonElement(errorBodyString)
            val jsonObject = jsonElement.jsonObject
            if (jsonObject.containsKey(KEY_ERRORS).not()) return EMPTY_ERROR_BODY


            val errorsArray = jsonObject[KEY_ERRORS]?.jsonArray
                ?: return EMPTY_ERROR_BODY

            if (errorsArray.isEmpty()) return EMPTY_ERROR_BODY

            val firstErrorObject = errorsArray.firstOrNull()?.jsonObject
                ?: return EMPTY_ERROR_BODY

            if (firstErrorObject.containsKey(KEY_ERROR_CODE).not()) return EMPTY_ERROR_BODY

            firstErrorObject[KEY_ERROR_CODE]?.toString() ?: EMPTY_ERROR_BODY
        }.onSuccess { code ->
            return code
        }.onFailure {
            return EMPTY_ERROR_BODY
        }

        return EMPTY_ERROR_BODY
    }
}
