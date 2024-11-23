package com.hjw.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjw.domain.common.Result
import com.hjw.domain.common.WidgetError
import com.hjw.domain.model.Widgets
import com.hjw.domain.usecase.FetchWidgetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchWidgetListUseCase: FetchWidgetListUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Idle)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        fetchWidgetList()
    }

    private fun fetchWidgetList() {
        viewModelScope.launch {
            when (val result = fetchWidgetListUseCase()) {
                is Result.Error -> handleError(result.error)
                is Result.Success -> handleSuccess(result.data)
            }
        }
    }

    private fun handleError(error: WidgetError) {
        sendUiState(state = MainUiState.Error(error = error))
    }

    private fun handleSuccess(data: Widgets) {
        sendUiState(state = MainUiState.Success(data = data))
    }

    private fun sendUiState(state: MainUiState) {
        _uiState.update { state }
    }
}

