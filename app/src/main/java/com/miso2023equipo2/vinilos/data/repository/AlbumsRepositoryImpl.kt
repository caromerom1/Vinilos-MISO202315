package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.services.VinylsApiService

class AlbumsRepositoryImpl(
    private val vinylsApiService: VinylsApiService
) : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        return vinylsApiService.getAlbums()
    }

    override suspend fun getAlbum(id: String): Album {
        return vinylsApiService.getAlbum(id)
    }
}