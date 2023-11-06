package com.miso2023equipo2.vinilos.services

import com.miso2023equipo2.vinilos.data.model.Album
import retrofit2.http.GET
import retrofit2.http.Path


interface VinylsApiService {
    @GET("/albums")
    suspend fun getAlbums(): List<Album>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id") id: String): Album
}

