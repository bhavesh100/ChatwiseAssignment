package com.bhavesh.chatwiseassignment.ui.products_activity

import com.bhavesh.chatwiseassignment.domain.model.Product

data class ProductsState(
    val isLoading: Boolean = false,
    val data: List<Product> = emptyList(),
    val error: String = ""
)
