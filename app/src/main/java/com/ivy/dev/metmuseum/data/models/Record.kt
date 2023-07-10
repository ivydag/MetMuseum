package com.ivy.dev.metmuseum.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Record(
    @SerialName("floor")
    val floor: Int,
    @SerialName("galleryid")
    val galleryid: Int,
    @SerialName("gallerynumber")
    val gallerynumber: String,
    @SerialName("id")
    val id: Int,
    @SerialName("lastupdate")
    val lastupdate: String,
    @SerialName("name")
    val name: String,
    @SerialName("objectcount")
    val objectcount: Int,
    @SerialName("theme")
    val theme: String
)