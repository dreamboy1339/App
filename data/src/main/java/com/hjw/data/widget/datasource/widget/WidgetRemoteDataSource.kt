package com.hjw.data.widget.datasource.widget

import com.hjw.network.model.ApiResponse
import retrofit2.Response

interface WidgetRemoteDataSource {
    suspend fun fetchWidgetList(): Response<ApiResponse>
}
