package com.example.swipeapp.presentation.screens.addProduct.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.swipeapp.presentation.screens.addProduct.AddProductEvent
import com.example.swipeapp.presentation.screens.addProduct.AddProductViewModel
import com.example.swipeapp.presentation.screens.productList.ProductListEvent

@Composable
fun TopAppBar(navController: NavController, viewModel: AddProductViewModel) {
    Column {
        androidx.compose.material.TopAppBar(
            elevation = 0.dp,
            title = {
                Text(text = "")
            },
            backgroundColor = MaterialTheme.colors.onPrimary,
            navigationIcon = {
                IconButton(onClick = {
                    viewModel.onEvent(AddProductEvent.CloseButton(navController))
                }) {
                    Icon(Icons.Filled.Close, null, tint = MaterialTheme.colors.primary)
                }
            },
        )
    }
}
