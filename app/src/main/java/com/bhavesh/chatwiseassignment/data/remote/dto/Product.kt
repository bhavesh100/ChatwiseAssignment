package com.bhavesh.chatwiseassignment.data.remote.dto

import com.bhavesh.chatwiseassignment.domain.model.Product

data class Product(
    val availabilityStatus: String,
    val brand: String,
    val category: String,
    val description: String,
    val dimensions: Dimensions,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val meta: Meta,
    val minimumOrderQuantity: Int,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
    val reviews: List<Review>,
    val shippingInformation: String,
    val sku: String,
    val stock: Int,
    val tags: List<String>,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
    val weight: Int
){
    fun toProduct() = Product(
        id = id,
        name = title,
        description = description,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        sku = sku,
        dimensions = dimensions,
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus,
        returnPolicy = returnPolicy,
        images = images,
        thumbnail = thumbnail
    )
}