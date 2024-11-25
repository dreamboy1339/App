package com.hjw.app.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.app.ui.MainUiState
import com.hjw.app.ui.common.EmptyBody
import com.hjw.app.ui.common.ErrorBody
import com.hjw.app.ui.common.LoadingBody
import com.hjw.designsystem.AppPreview
import com.hjw.domain.common.WidgetError

@Composable
fun MainContent(
    uiState: MainUiState,
    modifier: Modifier = Modifier,
) {
    when (uiState) {
        MainUiState.Idle -> EmptyBody(modifier = modifier)
        MainUiState.Loading -> LoadingBody(modifier = modifier, shown = true)
        is MainUiState.Error -> ErrorBody(modifier = modifier, message = "오류가 발생했습니다.")
        is MainUiState.Success -> {
            MainBody(
                widgets = uiState.data,
                modifier = modifier,
            )
        }
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
