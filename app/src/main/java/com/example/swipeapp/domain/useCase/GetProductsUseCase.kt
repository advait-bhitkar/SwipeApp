package com.example.swipeapp.domain.useCase

import com.example.swipeapp.data.dto.toProduct
import com.example.swipeapp.data.repository.ProductRepository
import com.example.swipeapp.domain.model.Product
import com.example.swipeapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetProductsUseCase(
    private val repository: ProductRepository,
) {
    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getAllProducts().map { products -> products.toProduct() }
            emit(Resource.Success(products))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
        }
    }
}
