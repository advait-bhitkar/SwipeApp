package com.example.swipeapp.data.dto

data class ResponseDto(
    val message: String,
    val product_details: ProductDetails,
    val product_id: Int,
    val success: Boolean,
)
