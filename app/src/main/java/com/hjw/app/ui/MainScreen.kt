package com.hjw.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hjw.app.R
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.theme.AppColor
import com.hjw.designsystem.theme.AppTheme

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Text(
                modifier = Modifier
                    .background(color = AppColor.Gray)
                    .fillMaxWidth()
                    .padding(16.dp),
                text = stringResource(R.string.title_top_bar),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    ) {
        MainContent(modifier = Modifier.padding(it))
    }
}

@Composable
fun MainContent(modifier: Modifier) {
    // TODO: 콘텐츠들 보여주기
}

@Preview
@Composable
private fun MainScreenPreview() {
    AppTheme {
        AppPreview {
            MainScreen()
        }
    }
}
