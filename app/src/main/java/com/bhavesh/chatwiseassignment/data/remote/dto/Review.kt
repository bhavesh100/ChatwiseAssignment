package com.bhavesh.chatwiseassignment.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class Review(
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
)