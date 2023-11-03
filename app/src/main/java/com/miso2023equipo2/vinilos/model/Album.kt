package com.miso2023equipo2.vinilos.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class Album (
    val id:Int,
    val name:String,
    val cover:String
)