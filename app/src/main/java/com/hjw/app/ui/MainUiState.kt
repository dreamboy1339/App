package com.hjw.app.ui

sealed interface MainUiState {
    data object Idle : MainUiState
    data object Loading : MainUiState
    data class Success(val data: String) : MainUiState
    data object Error : MainUiState
}
