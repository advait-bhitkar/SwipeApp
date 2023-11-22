package com.example.swipeapp.utils

sealed class OrderBy {
    object Ascending : OrderBy()
    object Descending : OrderBy()
    object NoOrder : OrderBy()
}
