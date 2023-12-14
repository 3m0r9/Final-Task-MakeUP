package com.D121211105.makeup.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Makeup(
    val api_featured_image: String?,
    val brand: String?,
    val category: String?,
    val created_at: String?,
    val description: String?,
    val id: Int?,
    val image_link: String?,
    val name: String?,
    val price: String?,
    val product_api_url: String?,
    val product_colors: List<ProductColor>,
    val product_link: String?,
    val product_type: String?,
    val rating: Double?,
    val updated_at: String?,
    val website_link: String?
) : Parcelable