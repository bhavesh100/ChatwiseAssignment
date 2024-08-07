package com.bhavesh.chatwiseassignment.data.remote

import com.bhavesh.chatwiseassignment.data.remote.dto.ProductsDto
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProducts():ProductsDto
}