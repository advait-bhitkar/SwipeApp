package com.example.swipeapp.presentation.screens.addProduct

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.swipeapp.presentation.screens.addProduct.components.*

@Composable
fun AddProduct(viewModel: AddProductViewModel, navController: NavController) {
    val imageUri by viewModel.imageUriState.collectAsState()
    val isLoadingDialog by viewModel.isLoadingDialogState.collectAsState()
    val showSuccessMessage by viewModel.showSuccessMessageState.collectAsState()
    val successMessage by viewModel.successMessageState.collectAsState()

    TopAppBar(navController = navController, viewModel)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(80.dp))
        productImage(viewModel, imageUri)
        Spacer(modifier = Modifier.height(16.dp))
        productDetails(viewModel)
        addProductButton(viewModel, imageUri)
        loadingDialog(showDialog = isLoadingDialog)
        snackBar(showSnackBar = showSuccessMessage, successMessage, viewModel)
    }
}
