package com.bhavesh.chatwiseassignment.data.repository

import com.bhavesh.chatwiseassignment.data.remote.ProductsApi
import com.bhavesh.chatwiseassignment.data.remote.dto.Product
import com.bhavesh.chatwiseassignment.data.remote.dto.ProductsDto
import com.bhavesh.chatwiseassignment.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    val productsApi: ProductsApi
): ProductsRepository {
    override suspend fun getProductsDto(): ProductsDto {
        return productsApi.getProducts()
    }
}