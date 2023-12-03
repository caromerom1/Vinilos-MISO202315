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
) {
    fun toAlbumDetail(): AlbumDetail {
        return AlbumDetail(
            id = this.id,
            name = this.name,
            cover = this.cover,
            description = this.description,
            genre = this.genre,
            releaseDate = this.releaseDate,
            recordLabel = this.recordLabel,
            comments = listOf(),
        )
    }
}

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