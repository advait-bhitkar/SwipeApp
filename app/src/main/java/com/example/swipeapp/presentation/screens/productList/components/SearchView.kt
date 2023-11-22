package com.example.swipeapp.presentation.screens.productList.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipeapp.R
import com.example.swipeapp.presentation.screens.productList.ProductListEvent
import com.example.swipeapp.presentation.screens.productList.ProductListViewModel

@Composable
fun searchView(searchText: String, viewModel: ProductListViewModel) {
    TextField(
        value = searchText,
        onValueChange = { newText ->
            viewModel.onEvent(ProductListEvent.SearchTextChanged(newText))
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textStyle = TextStyle(color = Color(0xFF808080), fontSize = 18.sp),
        placeholder = { Text(text = "Search product...", fontSize = 16.sp) },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp),
            )
        },
        trailingIcon = {
            if (searchText != TextFieldValue("").text) {
                IconButton(
                    onClick = {
                        viewModel.onEvent(ProductListEvent.SearchTextChanged(""))
                    },
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp),
                        tint = Color(0xFF808080),
                    )
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(32.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF808080),
            cursorColor = Color(0xFF808080),
            leadingIconColor = Color(0xFF808080),
            trailingIconColor = Color(0xFF808080),
            backgroundColor = colorResource(id = R.color.grey),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
    )
}
