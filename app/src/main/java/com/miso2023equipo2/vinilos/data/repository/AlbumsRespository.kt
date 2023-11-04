package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.services.VinylsApi

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(id: String): Album
}

class AlbumsRepositoryImpl : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        return VinylsApi.retrofitService.getAlbums()
    }

    override suspend fun getAlbum(id: String): Album {
        return VinylsApi.retrofitService.getAlbum(id)
    }
}