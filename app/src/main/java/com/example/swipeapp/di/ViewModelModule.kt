package com.example.swipeapp.di

import com.example.swipeapp.presentation.screens.addProduct.AddProductViewModel
import com.example.swipeapp.presentation.screens.productList.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        ProductListViewModel(
            get(named("getProductUseCase")),
        )
    }

    viewModel {
        AddProductViewModel(
            get(named("addProductsUseCase")),
        )
    }
}
