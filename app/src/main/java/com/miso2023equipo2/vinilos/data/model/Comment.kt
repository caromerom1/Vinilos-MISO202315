package com.miso2023equipo2.vinilos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    @SerialName("id") val id: Int,
    @SerialName("description") val description: String,
    @SerialName("rating") val rating: Int,
)

@Serializable
data class CommentCreate(
    @SerialName("description") val description: String,
    @SerialName("rating") val rating: Int,
    @SerialName("collector") val collector: CommentCreateCollector,
)

@Serializable
data class CommentCreateCollector(
    @SerialName("id") val id: Int
)