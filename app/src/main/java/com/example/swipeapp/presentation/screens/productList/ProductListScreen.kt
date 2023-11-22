package com.example.swipeapp.presentation.screens.productList

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.swipeapp.domain.model.Product
import com.example.swipeapp.presentation.screens.productList.components.circularIndicator
import com.example.swipeapp.presentation.screens.productList.components.productListItem
import com.example.swipeapp.presentation.screens.productList.components.searchView
import com.example.swipeapp.presentation.screens.productList.components.topAppBar

@Composable
fun ProductList(viewModel: ProductListViewModel, navController: NavController) {
    val searchText by viewModel.searchTextState.collectAsState()
    val products by viewModel.products.collectAsState(emptyList())
    val isLoading by viewModel.isLoadingState.collectAsState()

    Column {
        Scaffold(topBar = { topAppBar(navController, viewModel) }) {
            Column(modifier = Modifier.padding(it)) {
                searchView(searchText, viewModel = viewModel)
                Box() {
                    AllProducts(products = products)
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        circularIndicator(loading = isLoading)
                    }
                }
            }
        }
    }
}

@Composable
fun AllProducts(products: List<Product>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        items(products) { product ->
            productListItem(product)
        }
    }
}
