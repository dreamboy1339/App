package com.hjw.app.ui.model.content

import com.hjw.app.ui.model.Content

data class Product(
    val linkUrl: String,
    val thumbnailUrl: String,
    val brandName: String,
    val price: Int,
    val saleRate: Int,
    val hasCoupon: Boolean,
) : Content

class Goods(goodsList: List<Product>) : List<Product> by goodsList
