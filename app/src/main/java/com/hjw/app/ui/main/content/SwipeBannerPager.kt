package com.hjw.app.ui.main.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import com.hjw.designsystem.component.content.MDSBanner
import com.hjw.domain.model.content.Banners
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

private const val BANNER_SWIPE_DURATION = 3000L

@Composable
fun SwipeBannerPager(
    banners: Banners,
    bannerAutoSwipeDuration: Long = BANNER_SWIPE_DURATION,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { banners.size })

    LaunchedEffect(Unit) {
        while (true) {
            delay(bannerAutoSwipeDuration) // 3초
            if (pagerState.currentPage < banners.size - 1) {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            } else {
                pagerState.animateScrollToPage(0)
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) { page ->
        val banner = banners[page]
        MDSBanner(
            modifier = modifier
                .fillMaxSize()
                .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction)
                            .absoluteValue
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                },
            index = (page + 1),
            total = banners.size,
            linkUrl = banner.linkUrl,
            thumbnailUrl = banner.thumbnailUrl,
            title = banner.title,
            description = banner.description,
            keyword = banner.keyword
        )
    }
}
