package com.D121211105.movie.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ProductColor(
    val colour_name: String,
    val hex_value: String
): Parcelable