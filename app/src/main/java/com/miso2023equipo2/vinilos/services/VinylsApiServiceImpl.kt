package com.miso2023equipo2.vinilos.services

import com.miso2023equipo2.vinilos.data.model.Album
import retrofit2.http.GET
import retrofit2.http.Path


interface VinylsApiServiceImpl:VinylsApiServiceAdapter {
    @GET("/albums")
    override suspend fun getAlbums(): List<Album>

    @GET("/albums/{id}")
    override suspend fun getAlbum(@Path("id") id: String):Album
}

