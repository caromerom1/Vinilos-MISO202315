package com.miso2023equipo2.vinilos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Collector(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("telephone") val phone: String,
    @SerialName("email") val email: String,
    @SerialName("collectorAlbums") val collectorAlbums: List<CollectorAlbum>,
    @SerialName("favoritePerformers") val favoritePerformers: List<CollectorArtist>,
)

@Serializable
data class CollectorAlbum(
    @SerialName("id") val id: Int,
    @SerialName("price") val price: Double,
    @SerialName("status") val status: String,
)

@Serializable
data class CollectorArtist(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("image") val image: String,
    @SerialName("creationDate") val creationDate: String,
    @SerialName("description") val description: String,
)

