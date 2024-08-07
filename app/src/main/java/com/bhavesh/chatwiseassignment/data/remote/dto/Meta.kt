package com.bhavesh.chatwiseassignment.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class Meta(
    val barcode: String,
    val createdAt: String,
    val qrCode: String,
    val updatedAt: String
)