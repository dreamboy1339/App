package com.hjw.data.widget

import com.hjw.network.model.ApiResponse
import retrofit2.Response

interface WidgetRemoteDataSource {
    suspend fun fetchWidgetList(): Response<ApiResponse>
}
