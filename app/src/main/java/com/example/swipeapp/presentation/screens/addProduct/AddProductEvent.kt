package com.example.swipeapp.presentation.screens.addProduct

import android.content.Context
import android.net.Uri
import androidx.navigation.NavController

sealed class AddProductEvent {
    data class ProductNameEntered(val value: String) : AddProductEvent()
    data class ProductCategoryEntered(val value: String) : AddProductEvent()
    data class ProductPriceEntered(val value: String) : AddProductEvent()
    data class ProductTaxEntered(val value: String) : AddProductEvent()
    data class CloseButton(val navController: NavController) : AddProductEvent()
    data class AddProductButton(val context: Context, val imageUri: Uri) : AddProductEvent()
    data class SelectProductImage(val imageUri: Uri) : AddProductEvent()
}
