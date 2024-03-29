package com.miso2023equipo2.vinilos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Album(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("cover") val cover: String,
    @SerialName("description") val description: String,
    @SerialName("genre") val genre: String,
    @SerialName("releaseDate") val releaseDate: String,
    @SerialName("recordLabel") val recordLabel: String,
)

@Serializable
data class AlbumDetail(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("cover") val cover: String,
    @SerialName("description") val description: String,
    @SerialName("genre") val genre: String,
    @SerialName("releaseDate") val releaseDate: String,
    @SerialName("recordLabel") val recordLabel: String,
    @SerialName("comments") val comments: List<Comment>,
)

@Serializable
data class AlbumCreate(
    @SerialName("name") val name: String,
    @SerialName("cover") val cover: String,
    @SerialName("description") val description: String,
    @SerialName("genre") val genre: String,
    @SerialName("releaseDate") val releaseDate: String,
    @SerialName("recordLabel") val recordLabel: String,
)