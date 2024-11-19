package com.hjw.app_catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hjw.designsystem.component.Header
import com.hjw.designsystem.theme.AppTheme
import com.hjw.designsystem.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Catalog() {
    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text("Catalog")
                    }
                )
            }
        ) { innerPadding ->
            val modifier = Modifier.background(color = Color(0x27000000))
            LazyColumn(
                modifier = Modifier
                    .padding(Spacing.s),
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(Spacing.s)
            ) {
                item {
                    Text(text = "Header", style = MaterialTheme.typography.headlineLarge)
                }
                item {
                    Header(
                        title = "클리어런스",
                        modifier = modifier
                    )
                }
                item {
                    Header(
                        title = "클리어런스",
                        modifier = modifier,
                        iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
                    )
                }
                item {
                    Header(
                        title = "클리어런스",
                        modifier = modifier,
                        linkUrl = "https://www.musinsa.com"
                    )
                }
                item {
                    Header(
                        title = "클리어런스",
                        modifier = modifier,
                        iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
                        linkUrl = "https://www.musinsa.com"
                    )
                }
            }
        }
    }
}
