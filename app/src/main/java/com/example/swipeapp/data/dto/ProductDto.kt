package com.example.swipeapp.data.dto

import com.example.swipeapp.domain.model.Product

data class ProductDto(
    val image: String,
    val price: Double,
    val product_name: String,
    val product_type: String,
    val tax: Double,
)

fun ProductDto.toProduct(): Product {
    return Product(
        productName = product_name,
        productType = product_type,
        imageUrl = image,
        price = price,
        tax = tax,
    )
}
