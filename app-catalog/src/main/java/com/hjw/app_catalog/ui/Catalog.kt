package com.hjw.app_catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hjw.designsystem.component.content.Banner
import com.hjw.designsystem.component.content.Product
import com.hjw.designsystem.component.footer.Footer
import com.hjw.designsystem.component.footer.FooterType
import com.hjw.designsystem.component.header.Header
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
            val modifier = Modifier.background(color = Color.White)
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
                        title = "Header",
                        modifier = modifier
                    )
                }
                item {
                    Header(
                        title = "Header with icon",
                        modifier = modifier,
                        iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
                    )
                }
                item {
                    Header(
                        title = "Header with link",
                        modifier = modifier,
                        linkUrl = "https://www.musinsa.com"
                    )
                }
                item {
                    Header(
                        title = "Header with icon & link",
                        modifier = modifier,
                        iconUrl = "https://image.msscdn.net/icons/mobile/clock.png",
                        linkUrl = "https://www.musinsa.com"
                    )
                }

                item {
                    Text(text = "Banner", style = MaterialTheme.typography.headlineLarge)
                }
                item {
                    Banner(
                        index = 99,
                        total = 99,
                        linkUrl = "https://www.musinsa.com/app/plan/views/22278",
                        thumbnailUrl = "https://image.msscdn.net/images/event_banner/2022062311154900000044053.jpg",
                        title = "하이드아웃 S/S 시즌오프",
                        description = "최대 30% 할인",
                        keyword = "세일",
                    )
                }
                item {
                    Banner(
                        index = 99,
                        total = 99,
                        linkUrl = "https://www.musinsa.com/app/plan/views/22272",
                        thumbnailUrl = "https://image.msscdn.net/images/event_banner/2022062211292700000012174.jpg",
                        title = "아모프레 22 핫 서머 인기상품",
                        description = "단독 최대 10% 할인",
                        keyword = "단독 세일",
                    )
                }
                item {
                    Banner(
                        index = 99,
                        total = 99,
                        linkUrl = "https://www.musinsa.com/app/campaign/index/junebeautyfull",
                        thumbnailUrl = "https://image.msscdn.net/images/event_banner/2022061009432800000059650.jpg",
                    )
                }

                item {
                    Text(text = "Product", style = MaterialTheme.typography.headlineLarge)
                }
                item {
                    Product(
                        linkUrl = "https://www.musinsa.com/app/goods/2281818",
                        thumbnailUrl = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
                        brandName = "아스트랄 프로젝션",
                        price = 39900,
                        saleRate = 50,
                        hasCoupon = true,
                        modifier = Modifier.width(150.dp)
                    )
                }
                item {
                    Product(
                        linkUrl = "https://www.musinsa.com/app/goods/2281818",
                        thumbnailUrl = "https://image.msscdn.net/images/goods_img/20211224/2281818/2281818_1_320.jpg",
                        brandName = "아스트랄 프로젝션",
                        price = 39900,
                        saleRate = 50,
                        hasCoupon = false,
                        modifier = Modifier.width(150.dp)
                    )
                }

                item {
                    Text(text = "Footer", style = MaterialTheme.typography.headlineLarge)
                }
                item {
                    Footer(
                        type = FooterType.REFRESH,
                        title = "새로운 추천",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    Footer(
                        type = FooterType.MORE,
                        title = "더보기",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
