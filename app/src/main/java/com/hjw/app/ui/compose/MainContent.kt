package com.hjw.app.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hjw.app.ui.MainUiState

@Composable
fun MainContent(
    mainUiState: MainUiState,
    modifier: Modifier = Modifier,
) {
    if (mainUiState is MainUiState.Idle) return
}
