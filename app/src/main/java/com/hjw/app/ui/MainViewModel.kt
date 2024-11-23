package com.hjw.app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjw.domain.usecase.FetchWidgetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchWidgetListUseCase: FetchWidgetListUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState.Idle)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        fetchWidgetList()
    }

    private fun fetchWidgetList() {
        viewModelScope.launch {
            val result = fetchWidgetListUseCase()
            Log.d("fog", "fetchWidgetList: ${result.getOrNull()}")
        }
    }
}

