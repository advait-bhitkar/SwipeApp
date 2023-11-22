package com.example.swipeapp.presentation.screens.addProduct.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipeapp.presentation.screens.addProduct.AddProductEvent
import com.example.swipeapp.presentation.screens.addProduct.AddProductViewModel
import com.example.swipeapp.presentation.theme.CustomTypography

@Composable
fun productDetails(viewModel: AddProductViewModel) {
    val productName by viewModel.productNameState.collectAsState()
    val productCategory by viewModel.productCategoryState.collectAsState()
    val productPrice by viewModel.productPriceState.collectAsState()
    val productTax by viewModel.productTaxState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(2.dp, color = Color(0xFFF0F0F0), shape = RoundedCornerShape(4.dp))
            .padding(16.dp, 0.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Product Name",
                style = CustomTypography.body1,
            )

            TextField(
                value = productName,
                singleLine = true,
                onValueChange = {
                        newText ->
                    viewModel.onEvent(AddProductEvent.ProductNameEntered(newText))
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF808080),
                    cursorColor = Color(0xFF808080),
                    leadingIconColor = Color(0xFF808080),
                    trailingIconColor = Color(0xFF808080),
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Enter name...",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterEnd),
                        )
                    }
                },

                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            )
        }

        Box(
            modifier = Modifier
                .background(Color(0xffeeeeee))
                .fillMaxWidth()
                .height(1.dp),
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Product Category",
                style = CustomTypography.body1,
            )

            TextField(
                value = productCategory,
                singleLine = true,
                onValueChange = {
                        newText ->
                    viewModel.onEvent(AddProductEvent.ProductCategoryEntered(newText))
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF808080),
                    cursorColor = Color(0xFF808080),
                    leadingIconColor = Color(0xFF808080),
                    trailingIconColor = Color(0xFF808080),
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Enter cateogry...",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterEnd),
                        )
                    }
                },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            )
        }
    }

    Text(
        text = "Price and Tax",
        style = CustomTypography.body1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp, 16.dp, 0.dp, 0.dp),
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(2.dp, color = Color(0xFFF0F0F0), shape = RoundedCornerShape(4.dp))
            .padding(16.dp, 0.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Price",
                style = CustomTypography.body1,
            )

            TextField(
                value = productPrice,
                singleLine = true,
                onValueChange = {
                        newText ->
                    viewModel.onEvent(AddProductEvent.ProductPriceEntered(newText))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF808080),
                    cursorColor = Color(0xFF808080),
                    leadingIconColor = Color(0xFF808080),
                    trailingIconColor = Color(0xFF808080),
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Enter price...",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterEnd),
                        )
                    }
                },

                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            )
        }

        Box(
            modifier = Modifier
                .background(Color(0xffeeeeee))
                .fillMaxWidth()
                .height(1.dp),
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Tax",
                style = CustomTypography.body1,
            )

            TextField(
                value = productTax,
                singleLine = true,
                onValueChange = {
                        newText ->
                    viewModel.onEvent(AddProductEvent.ProductTaxEntered(newText))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF808080),
                    cursorColor = Color(0xFF808080),
                    leadingIconColor = Color(0xFF808080),
                    trailingIconColor = Color(0xFF808080),
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Enter tax %...",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterEnd),
                        )
                    }
                },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
            )
        }
    }
}
