package com.example.swipeapp.presentation.screens.productList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.swipeapp.R
import com.example.swipeapp.domain.model.Product
import com.example.swipeapp.presentation.theme.CustomTypography

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun productListItem(
    product: Product,
) {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth(),
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp),
            ) {
                GlideImage(
                    model = product.imageUrl,
                    contentDescription = "Product Image",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .background(Color.White),
                    failure = placeholder(R.drawable.product_placeholder),
                    loading = placeholder(R.drawable.product_placeholder),
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp, 0.dp, 0.dp, 0.dp),
                ) {
                    Text(
                        text = product.productName.replace("\n", ""),
                        style = CustomTypography.body1,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 4.dp),
                    )
                    Text(
                        text = product.productType,
                        style = CustomTypography.subtitle1,
                    )
                }
                Column(
                    modifier = Modifier.height(IntrinsicSize.Min),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "\u20B9 ${product.price}",
                        style = CustomTypography.body2,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 4.dp),
                        textAlign = TextAlign.End,
                    )
                    Text(
                        text = "Tax ${product.tax}%",
                        style = CustomTypography.subtitle2,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                        textAlign = TextAlign.Right,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .background(Color(0xffeeeeee))
                    .fillMaxWidth()
                    .height(1.dp),
            )
        }
    }
}
