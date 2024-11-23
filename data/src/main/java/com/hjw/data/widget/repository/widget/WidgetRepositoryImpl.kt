package com.hjw.data.widget.repository.widget

import com.hjw.data.widget.datasource.widget.WidgetRemoteDataSource
import com.hjw.data.widget.mapper.widget.toEntity
import com.hjw.domain.common.Result
import com.hjw.domain.common.WidgetError
import com.hjw.domain.model.Widgets
import com.hjw.domain.repository.WidgetRepository
import com.hjw.network.common.ErrorBodyParser
import okhttp3.ResponseBody
import java.net.HttpURLConnection
import javax.inject.Inject

class WidgetRepositoryImpl @Inject constructor(
    private val dataSource: WidgetRemoteDataSource,
) : WidgetRepository {

    override suspend fun fetchWidgetList(): Result<Widgets, WidgetError> {
        runCatching {
            dataSource.fetchWidgetList()
        }.onSuccess { response ->
            if (response.isSuccessful.not()) {
                return handlingResponseError(
                    status = response.code(),
                    errorBody = response.errorBody()
                )
            }

            val body = response.body()
            return if (body != null) {
                Result.Success(body.toEntity())
            } else {
                Result.Error(WidgetError.Network.EMPTY_RESPONSE)
            }
        }.onFailure { t ->
            return Result.Error(WidgetError.GenericError(t))
        }

        return Result.Error(WidgetError.Network.UNKNOWN)
    }

    private fun handlingResponseError(
        status: Int,
        errorBody: ResponseBody?,
    ): Result.Error<Widgets, WidgetError> {
        val error = if (status < HttpURLConnection.HTTP_INTERNAL_ERROR) {
            WidgetError.HttpClientError(status = status.toString())
        } else {
            val errorMessage = ErrorBodyParser.parse(errorBodyString = errorBody?.toString())
            WidgetError.ServerError(message = errorMessage)
        }
        return Result.Error(error)
    }
}
