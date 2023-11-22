package com.example.swipeapp.utils

sealed class Screen(val route: String) {
    object ProductListScreen : Screen("product_list_screen")
    object AddProductScreen : Screen("add_product_screen")
}
