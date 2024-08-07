package com.bhavesh.chatwiseassignment.domain.repository

import com.bhavesh.chatwiseassignment.data.remote.dto.Product
import com.bhavesh.chatwiseassignment.data.remote.dto.ProductsDto
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsDto(): ProductsDto
}