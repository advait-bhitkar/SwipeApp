package com.example.swipeapp.presentation.screens.addProduct.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.swipeapp.R
import com.example.swipeapp.presentation.screens.addProduct.AddProductEvent
import com.example.swipeapp.presentation.screens.addProduct.AddProductViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun productImage(viewModel: AddProductViewModel, imageUri: Uri) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            viewModel.onEvent(AddProductEvent.SelectProductImage(it))
        }
    }
    Box() {
        GlideImage(
            model = imageUri,
            contentDescription = null,
            loading = placeholder(R.drawable.add_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clickable {
                    launcher.launch("image/*")
                }
                .size(200.dp)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(4.dp),
                ),
        )
    }
}
