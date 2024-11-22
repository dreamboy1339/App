package com.hjw.data.widget

import com.hjw.network.api.MusinsaApi
import com.hjw.network.model.ApiResponse
import retrofit2.Response
import javax.inject.Inject

class WidgetRemoteDataSourceImpl @Inject constructor(
    private val api: MusinsaApi,
) : WidgetRemoteDataSource {

    override suspend fun fetchWidgetList(): Response<ApiResponse> = api.fetchWidgetList()
}
