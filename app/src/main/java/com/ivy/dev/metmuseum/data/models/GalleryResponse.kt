package com.ivy.dev.metmuseum.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GalleryResponse(
    @SerialName("info")
    val info: Info,
    @SerialName("records")
    val records: List<Record>
)