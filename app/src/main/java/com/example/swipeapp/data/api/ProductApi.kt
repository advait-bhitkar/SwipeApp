package com.example.swipeapp.data.api

import com.example.swipeapp.data.dto.ProductDto
import com.example.swipeapp.data.dto.ResponseDto
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApi {
    @GET("/api/public/get")
    suspend fun getAllProducts(): List<ProductDto>

    @POST("/api/public/add")
    suspend fun addProduct(
        @Body body: RequestBody,
    ): Response<ResponseDto>
}
