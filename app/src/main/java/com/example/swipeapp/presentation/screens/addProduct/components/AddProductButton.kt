package com.example.swipeapp.presentation.screens.addProduct.components

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipeapp.presentation.screens.addProduct.AddProductEvent
import com.example.swipeapp.presentation.screens.addProduct.AddProductViewModel

@Composable
fun addProductButton(viewModel: AddProductViewModel, imageUri: Uri) {
    val context = LocalContext.current

    Button(
        onClick = {
            viewModel.onEvent(AddProductEvent.AddProductButton(context, imageUri))
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "Add Product",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(8.dp),
        )
    }
}
