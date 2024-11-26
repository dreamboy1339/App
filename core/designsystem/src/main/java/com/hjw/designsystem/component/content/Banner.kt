package com.hjw.designsystem.component.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.hjw.designsystem.AppPreview
import com.hjw.designsystem.theme.MDSColor
import com.hjw.designsystem.theme.Spacing

@Composable
fun MDSBanner(
    index: Int,
    total: Int,
    linkUrl: String,
    thumbnailUrl: String,
    title: String = "",
    description: String = "",
    keyword: String = "",
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        AsyncImage(
            model = thumbnailUrl,
            contentDescription = keyword,
            modifier = Modifier
                .fillMaxSize()
        )

        BannerGuide(
            title = title,
            subTitle = if (keyword.isEmpty() && description.isEmpty()) {
                ""
            } else {
                "$keyword | $description"
            },
            index = index,
            total = total,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun BannerGuide(
    title: String,
    subTitle: String,
    index: Int,
    total: Int,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (title.isNotEmpty()) {
                Spacer(modifier = Modifier.height(Spacing.s))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MDSColor.White
                )
            }

            if (subTitle.isNotEmpty()) {
                Spacer(modifier = Modifier.height(Spacing.m))
                Text(
                    text = subTitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MDSColor.White
                )
            }

            Spacer(modifier = Modifier.height(Spacing.s))

            Indicator(
                index = index,
                total = total,
                modifier = Modifier
                    .align(Alignment.End)
                    .background(MDSColor.Black_Opaque)
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }
    }
}

@Composable
private fun Indicator(
    index: Int,
    total: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = "$index / $total",
        style = MaterialTheme.typography.labelSmall,
        color = MDSColor.White
    )
}

@Preview(showBackground = true)
@Composable
private fun BannerPreview() {
    AppPreview {
        MDSBanner(
            index = 99,
            total = 99,
            linkUrl = "https://www.musinsa.com/app/plan/views/22278",
            thumbnailUrl = "https://image.msscdn.net/images/event_banner/2022062311154900000044053.jpg",
            title = "하이드아웃 S/S 시즌오프",
            description = "최대 30% 할인",
            keyword = "세일"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BannerWithNoTitleAndDescriptionPreview() {
    AppPreview {
        MDSBanner(
            index = 99,
            total = 99,
            linkUrl = "https://www.musinsa.com/app/plan/views/22278",
            thumbnailUrl = "https://image.msscdn.net/images/event_banner/2022062311154900000044053.jpg",
        )
    }
}
