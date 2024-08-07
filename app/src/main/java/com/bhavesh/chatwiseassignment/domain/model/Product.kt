package com.bhavesh.chatwiseassignment.domain.model

import android.os.Parcelable
import com.bhavesh.chatwiseassignment.data.remote.dto.Dimensions
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
//    val brand: String,
    val sku: String,
//    val weight: Int,
    val dimensions: Dimensions,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val returnPolicy: String,
    val images: List<String>,
    val thumbnail: String
): Parcelable