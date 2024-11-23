package com.hjw.domain.model.content

data class Product(
    val linkUrl: String,
    val thumbnailUrl: String,
    val brandName: String,
    val price: Int,
    val saleRate: Int,
    val hasCoupon: Boolean,
) : Content

class Goods(productList: List<Product>) : List<Product> by productList
