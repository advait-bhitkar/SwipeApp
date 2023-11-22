package com.example.swipeapp.presentation.screens.productList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swipeapp.domain.model.Product
import com.example.swipeapp.domain.useCase.GetProductsUseCase
import com.example.swipeapp.utils.OrderBy
import com.example.swipeapp.utils.Resource
import com.example.swipeapp.utils.Screen
import kotlinx.coroutines.flow.* // ktlint-disable no-wildcard-imports

class ProductListViewModel(
    private val getProductsUseCase: GetProductsUseCase,
) : ViewModel() {

    private val _searchTextState = MutableStateFlow("")
    val searchTextState: StateFlow<String> = _searchTextState

    private val _productListState = MutableStateFlow(listOf<Product>())
    val productListState: MutableStateFlow<List<Product>> = _productListState

    private val _isLoadingState = MutableStateFlow(false)
    val isLoadingState: StateFlow<Boolean> = _isLoadingState

    private val _productOrderState = MutableStateFlow<OrderBy>(OrderBy.NoOrder)

    init {
        getProducts(OrderBy.NoOrder)
    }

    private fun getProducts(productOrder: OrderBy) {
        getProductsUseCase().onEach {
                result ->
            when (result) {
                is Resource.Success -> {
                    when (productOrder) {
                        is OrderBy.NoOrder -> {
                            _productListState.value = result.data ?: emptyList()
                        }
                        is OrderBy.Ascending -> _productListState.value = result.data?.sortedBy { it.productName }
                            ?: emptyList()
                        is OrderBy.Descending -> _productListState.value = result.data?.sortedByDescending { it.productName }
                            ?: emptyList()
                    }

                    _isLoadingState.value = false
                }
                is Resource.Loading -> {
                    _isLoadingState.value = true
                }
                is Resource.Error -> {
                    Log.d("Swipe App", result.message ?: "Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }

    val products = searchTextState.combine(_productListState) { searchText, products ->
        if (searchText.isBlank()) {
            products
        } else {
            products.filter { it.productName.lowercase().contains(searchText.lowercase()) }
        }
    }

    fun onEvent(event: ProductListEvent) {
        when (event) {
            is ProductListEvent.SearchTextChanged -> {
                _searchTextState.value = event.value
            }
            is ProductListEvent.AddProduct -> {
                event.navController.navigate(Screen.AddProductScreen.route)
            }
            is ProductListEvent.SortList -> {
                when (_productOrderState.value) {
                    is OrderBy.NoOrder -> {
                        _productOrderState.value = OrderBy.Ascending
                    }
                    is OrderBy.Ascending -> {
                        _productOrderState.value = OrderBy.Descending
                    }
                    is OrderBy.Descending -> {
                        _productOrderState.value = OrderBy.NoOrder
                    }
                }
                getProducts(_productOrderState.value)
            }
        }
    }
}
