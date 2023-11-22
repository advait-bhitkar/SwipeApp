package com.example.swipeapp.presentation.screens.addProduct

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swipeapp.domain.model.Product
import com.example.swipeapp.domain.useCase.AddProductsUseCase
import com.example.swipeapp.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.io.File
import java.io.FileOutputStream

class AddProductViewModel(
    private val addProductsUseCase: AddProductsUseCase,
) : ViewModel() {

    private val _imageUriState = MutableStateFlow<Uri>(Uri.EMPTY)
    val imageUriState: MutableStateFlow<Uri> = _imageUriState

    private val _productDetailsState = MutableStateFlow(Product("", "", "", 0.0, 0.0))

    private val _productNameState = MutableStateFlow("")
    val productNameState: StateFlow<String> = _productNameState

    private val _productCategoryState = MutableStateFlow("")
    val productCategoryState: StateFlow<String> = _productCategoryState

    private val _productPriceState = MutableStateFlow("")
    val productPriceState: StateFlow<String> = _productPriceState

    private val _productTaxState = MutableStateFlow("")
    val productTaxState: StateFlow<String> = _productTaxState

    private val _isLoadingDialogState = MutableStateFlow(false)
    val isLoadingDialogState: StateFlow<Boolean> = _isLoadingDialogState

    private val _showSuccessMessageState = MutableStateFlow(false)
    val showSuccessMessageState: StateFlow<Boolean> = _showSuccessMessageState

    private val _successMessageState = MutableStateFlow("")
    val successMessageState: StateFlow<String> = _successMessageState

    fun dismissSnackBar() {
        _showSuccessMessageState.value = false
    }

    private fun addProductToServer(file: File, context: Context) {
        if (_productNameState.value.isEmpty()) {
            Toast.makeText(context, "Please Enter product name", Toast.LENGTH_SHORT).show()
            return
        }
        if (_productCategoryState.value.isEmpty()) {
            Toast.makeText(context, "Please Enter product category", Toast.LENGTH_SHORT).show()
            return
        }
        if (_productPriceState.value.isEmpty()) {
            Toast.makeText(context, "Please Enter product price", Toast.LENGTH_SHORT).show()
            return
        }
        if (_productTaxState.value.isEmpty()) {
            Toast.makeText(context, "Please Enter product tax", Toast.LENGTH_SHORT).show()
            return
        }


        val product = Product(
            _productNameState.value,
            _productCategoryState.value,
            "",
            _productPriceState.value.toDouble(),
            _productTaxState.value.toDouble())

        addProductsUseCase(product = product, file).onEach {
                result ->
            when (result) {
                is Resource.Success -> {
                    _isLoadingDialogState.value = false
                    _showSuccessMessageState.value = true
                    _successMessageState.value = "Product Added Successfully."
                }
                is Resource.Loading -> {
                    _isLoadingDialogState.value = true
                }
                is Resource.Error -> {
                    Log.d("Swipe App", result.message ?: "Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: AddProductEvent) {
        when (event) {
            is AddProductEvent.ProductNameEntered -> {
                _productNameState.value = event.value
            }
            is AddProductEvent.ProductCategoryEntered -> {
                _productCategoryState.value = event.value
            }

            is AddProductEvent.ProductPriceEntered -> {
                _productPriceState.value = event.value
            }
            is AddProductEvent.ProductTaxEntered -> {
                _productTaxState.value = event.value
            }
            is AddProductEvent.AddProductButton -> {
                val imageUri = event.imageUri
                val context = event.context
                if (imageUri == Uri.EMPTY) {
                    Toast.makeText(context, "Please Select Product Image", Toast.LENGTH_SHORT).show()
                    return
                }
                val filesDir = context.filesDir
                val file = File(filesDir, "image.png")
                val inputStream = context.contentResolver.openInputStream(imageUri)
                val outputStream = FileOutputStream(file)
                inputStream?.copyTo(outputStream)
                addProductToServer(file, event.context)
            }
            is AddProductEvent.CloseButton -> {
                event.navController.popBackStack()
            }
            is AddProductEvent.SelectProductImage -> {
                _imageUriState.value = event.imageUri
            }
        }
    }
}
