package com.hjw.app.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.designsystem.AppPreview

@Composable
fun MainBody(
    modifier: Modifier = Modifier,

) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        content = {
        }
    )
}

@Preview
@Composable
private fun MainBodyPreview() {
    AppPreview {
        MainBody()
    }
}
