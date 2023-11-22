package com.example.swipeapp.presentation.screens.productList.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.swipeapp.R
import com.example.swipeapp.presentation.screens.productList.ProductListEvent
import com.example.swipeapp.presentation.screens.productList.ProductListViewModel

@Composable
fun topAppBar(navController: NavController, viewModel: ProductListViewModel) {
    Column {
        TopAppBar(
            elevation = 0.dp,
            title = {
                Text(text = "Swipe")
            },
            backgroundColor = MaterialTheme.colors.onPrimary,
            actions = {
                IconButton(onClick = { viewModel.onEvent(ProductListEvent.SortList) }) {
                    Icon(painterResource(id = R.drawable.swap_vert), null, tint = MaterialTheme.colors.primary)
                }
                IconButton(onClick = { viewModel.onEvent(ProductListEvent.AddProduct(navController)) }) {
                    Icon(painter = painterResource(id = R.drawable.add), null, tint = MaterialTheme.colors.primary)
                }
            },
        )
    }
}
