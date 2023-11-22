package com.example.swipeapp.di

import com.example.swipeapp.domain.useCase.AddProductsUseCase
import com.example.swipeapp.domain.useCase.GetProductsUseCase
import org.koin.androidx.compose.get
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCasesModule = module {

    single(named("getProductUseCase")) { GetProductsUseCase(get()) }

    single(named("addProductsUseCase")) { AddProductsUseCase(get()) }
}
