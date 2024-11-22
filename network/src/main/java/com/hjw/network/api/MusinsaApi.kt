package com.hjw.network.api

import com.hjw.network.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface MusinsaApi {

    @GET("/interview/list.json")
    suspend fun fetchWidgetList(): Response<ApiResponse>
}
