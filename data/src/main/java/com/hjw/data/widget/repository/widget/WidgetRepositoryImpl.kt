package com.hjw.data.widget.repository.widget

import com.hjw.data.widget.datasource.widget.WidgetRemoteDataSource
import com.hjw.data.widget.mapper.widget.toWidgets
import com.hjw.domain.model.Widgets
import com.hjw.domain.repository.WidgetRepository
import com.hjw.network.exception.EmptyBodyResponseException
import com.hjw.network.exception.ResponseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WidgetRepositoryImpl @Inject constructor(
    private val dataSource: WidgetRemoteDataSource,
) : WidgetRepository {
    override suspend fun fetchWidgetList(): Result<Widgets> = withContext(Dispatchers.IO) {
        val response = dataSource.fetchWidgetList()

        if (response.isSuccessful.not()) {
            val exception = ResponseException(statusCode = response.code())
            return@withContext Result.failure(exception)
        }

        val apiResponse = response.body()
            ?: return@withContext Result.failure(EmptyBodyResponseException())

        Result.success(apiResponse.toWidgets())
    }
}
