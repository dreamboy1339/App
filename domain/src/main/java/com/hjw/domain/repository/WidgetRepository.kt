package com.hjw.domain.repository

import com.hjw.domain.model.Widgets

interface WidgetRepository {
    suspend fun fetchWidgetList(): Result<Widgets>
}
