package com.example.swipeapp.domain.useCase

import com.example.swipeapp.data.dto.ResponseDto
import com.example.swipeapp.data.repository.ProductRepository
import com.example.swipeapp.domain.model.Product
import com.example.swipeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.File
import java.io.IOException

class AddProductsUseCase(
    private val repository: ProductRepository,
) {
    operator fun invoke(product: Product, imageFile: File): Flow<Resource<Response<ResponseDto>>> =
        flow {
            try {
                emit(Resource.Loading())
                val requestBody: RequestBody = MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("product_name", product.productName)
                    .addFormDataPart("product_type", product.productType)
                    .addFormDataPart("price", product.price.toString())
                    .addFormDataPart("tax", product.tax.toString())
                    .addFormDataPart(
                        "files[]",
                        imageFile.name,
                        imageFile.asRequestBody("image/*".toMediaTypeOrNull()),
                    )
                    .build()
                val addProduct = repository.addProduct(requestBody)
                emit(Resource.Success(addProduct))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
            }
        }
}
