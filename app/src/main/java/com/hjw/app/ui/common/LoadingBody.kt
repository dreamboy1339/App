package com.hjw.app.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.hjw.app.R
import com.hjw.designsystem.AppPreview

@Composable
fun LoadingBody(
    shown: Boolean,
    modifier: Modifier = Modifier,
) {
    if (shown.not()) return

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(dimensionResource(R.dimen.loading_width)),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Preview
@Composable
private fun LoadingPreview() {
    AppPreview {
        LoadingBody(shown = true)
    }
}
