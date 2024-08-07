package com.bhavesh.chatwiseassignment.domain.model

import android.os.Parcelable
import com.bhavesh.chatwiseassignment.data.remote.dto.Dimensions
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val sku: String,
    val dimensions: Dimensions,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val returnPolicy: String,
    val images: List<String>,
    val thumbnail: String
): Parcelable