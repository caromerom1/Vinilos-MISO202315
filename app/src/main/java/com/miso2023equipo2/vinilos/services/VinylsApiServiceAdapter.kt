package com.miso2023equipo2.vinilos.services

import com.miso2023equipo2.vinilos.data.model.Album

interface VinylsApiServiceAdapter {
    suspend fun getAlbums(): List<Album>;
    suspend fun getAlbum(id: String):Album;

}