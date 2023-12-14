package com.D121211105.makeup.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ProductColor(
    val colour_name: String?,
    val hex_value: String?
) : Parcelable