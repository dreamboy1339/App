package com.hjw.app.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hjw.app.R
import com.hjw.app.ui.MainUiState
import com.hjw.app.ui.MainViewModel
import com.hjw.designsystem.theme.MDSColor

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Text(
                modifier = Modifier
                    .background(color = MDSColor.White)
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.toolbar_padding)),
                text = stringResource(R.string.title_top_bar),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    ) {
        val viewModel: MainViewModel = viewModel()
        val mainUiState: MainUiState by viewModel.uiState.collectAsStateWithLifecycle()

        MainContent(
            uiState = mainUiState,
            modifier = Modifier
                .background(color = Color.White)
                .padding(it)
        )
    }
}
