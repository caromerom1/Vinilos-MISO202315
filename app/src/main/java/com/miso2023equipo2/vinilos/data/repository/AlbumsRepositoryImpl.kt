package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.network.VinylsApi



class AlbumsRepositoryImpl():AlbumsRepository{
    override suspend fun getAlbums(): List<Album> {
        return VinylsApi.retrofitService.getAlbums()
    }


}