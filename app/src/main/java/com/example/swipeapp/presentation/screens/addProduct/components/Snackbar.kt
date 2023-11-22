package com.example.swipeapp.presentation.screens.addProduct.components

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.swipeapp.presentation.screens.addProduct.AddProductViewModel
import kotlinx.coroutines.launch

@Composable
fun snackBar(showSnackBar: Boolean, successMessage: String, viewModel: AddProductViewModel) {
    if (!showSnackBar) {
        return
    }
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState, // attaching `scaffoldState` to the `Scaffold`
    ) {
        val pad = it
        coroutineScope.launch {
            scaffoldState.snackbarHostState.showSnackbar(
                message = successMessage,
            )
            viewModel.dismissSnackBar()
        }
    }
}
