package com.example.swipeapp.domain.model

data class Product(
    var productName: String,
    var productType: String,
    val imageUrl: String,
    var price: Double,
    var tax: Double,
)
