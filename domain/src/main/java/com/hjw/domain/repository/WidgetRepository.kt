package com.hjw.domain.repository

import com.hjw.domain.common.Result
import com.hjw.domain.common.WidgetError
import com.hjw.domain.model.Widgets

interface WidgetRepository {
    suspend fun fetchWidgetList(): Result<Widgets, WidgetError>
}
