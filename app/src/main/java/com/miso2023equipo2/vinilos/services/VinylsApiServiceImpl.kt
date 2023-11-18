package com.miso2023equipo2.vinilos.services

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.Artist
import retrofit2.http.GET
import retrofit2.http.Path


interface VinylsApiServiceImpl:VinylsApiServiceAdapter {
    @GET("/albums")
    override suspend fun getAlbums(): List<Album>

    @GET("/albums/{id}")
    override suspend fun getAlbum(@Path("id") id: String):Album
    @GET("/bands")
    override  suspend fun getArtists():List<Artist>;
    @GET("/bands/{id}")
    override  suspend fun getArtist(@Path("id") id :String):Artist;
}

