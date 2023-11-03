package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.model.Album
import com.miso2023equipo2.vinilos.network.VinylsApi

interface AlbumsRepository {
    suspend fun  getAlbums():List<Album>

}

class NetworkAlbumsRepository():AlbumsRepository{
    override suspend fun getAlbums(): List<Album> {
        return VinylsApi.retrofitService.getAlbums()
    }

}