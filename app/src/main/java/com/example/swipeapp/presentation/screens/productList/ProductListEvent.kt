package com.example.swipeapp.presentation.screens.productList

import androidx.navigation.NavController

sealed class ProductListEvent {
    data class SearchTextChanged(val value: String) : ProductListEvent()
    data class AddProduct(val navController: NavController) : ProductListEvent()
    object SortList : ProductListEvent()
}
