package com.hjw.app.ui

import com.hjw.domain.common.WidgetError
import com.hjw.domain.model.Widgets

sealed interface MainUiState {
    data object Idle : MainUiState
    data object Loading : MainUiState
    data class Success(val data: Widgets) : MainUiState
    data class Error(val error: WidgetError) : MainUiState
}
