package com.miso2023equipo2.vinilos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("image") val cover: String,
    @SerialName("creationDate") val creationDate: String,
    @SerialName("description") val description: String,
)