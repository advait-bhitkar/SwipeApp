package com.example.swipeapp.di

import com.example.swipeapp.data.api.RetrofitInstance
import com.example.swipeapp.data.repository.ProductRepository
import org.koin.androidx.compose.get
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitInstance.api }
    single { ProductRepository(get()) }
}
