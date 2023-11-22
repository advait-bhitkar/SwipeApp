package com.example.swipeapp.data.repository

import com.example.swipeapp.data.api.ProductApi
import com.example.swipeapp.data.dto.ProductDto
import com.example.swipeapp.data.dto.ResponseDto
import okhttp3.RequestBody
import retrofit2.Response

class ProductRepository(private val api: ProductApi) {
    suspend fun getAllProducts(): List<ProductDto> = api.getAllProducts()
    suspend fun addProduct(body: RequestBody): Response<ResponseDto> = api.addProduct(body)
}
