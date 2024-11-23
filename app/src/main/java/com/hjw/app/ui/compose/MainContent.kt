package com.hjw.app.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.app.ui.MainUiState
import com.hjw.designsystem.AppPreview
import com.hjw.domain.common.WidgetError

@Composable
fun MainContent(
    mainUiState: MainUiState,
    modifier: Modifier = Modifier,
) {
    when (mainUiState) {
        MainUiState.Idle -> EmptyBody()
        MainUiState.Loading -> LoadingBody(shown = true)
        is MainUiState.Error -> ErrorBody(message = "오류가 발생했습니다.")
        is MainUiState.Success -> MainBody()
    }
}

@Preview
@Composable
private fun MainContentIdleStatePreview() {
    AppPreview {
        MainContent(MainUiState.Idle)
    }
}

@Preview
@Composable
private fun MainContentLoadingStatePreview() {
    AppPreview {
        MainContent(MainUiState.Loading)
    }
}

@Preview
@Composable
private fun MainContentErrorStatePreview() {
    AppPreview {
        MainContent(MainUiState.Error(error = WidgetError.Network.EMPTY_RESPONSE))
    }
}
