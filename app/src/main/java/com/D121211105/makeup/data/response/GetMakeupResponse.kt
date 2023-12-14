package com.D121211105.makeup.data.response

import com.D121211105.makeup.data.models.Makeup
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//class GetMakeupResponse : ArrayList<Makeup>()
@Serializable
data class GetMakeupResponse(
    @SerialName("makeup")
    val makeup: List<Makeup>
)