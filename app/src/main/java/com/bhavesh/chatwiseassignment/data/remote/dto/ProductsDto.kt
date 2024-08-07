package com.bhavesh.chatwiseassignment.data.remote.dto

data class ProductsDto(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)