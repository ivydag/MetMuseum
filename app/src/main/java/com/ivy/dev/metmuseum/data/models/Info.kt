package com.ivy.dev.metmuseum.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
    @SerialName("next")
    val next: String,
    @SerialName("page")
    val page: Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("responsetime")
    val responsetime: String,
    @SerialName("totalrecords")
    val totalrecords: Int,
    @SerialName("totalrecordsperquery")
    val totalrecordsperquery: Int
)