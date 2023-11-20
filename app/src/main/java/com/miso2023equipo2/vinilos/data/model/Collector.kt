package com.miso2023equipo2.vinilos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Collector(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("telephone") val phone: String,
    @SerialName("email") val email: String,
)
