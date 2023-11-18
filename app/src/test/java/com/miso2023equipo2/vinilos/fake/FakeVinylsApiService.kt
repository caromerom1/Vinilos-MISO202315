package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.services.VinylsApiServiceImpl

class FakeVinylsApiService:VinylsApiServiceImpl{
    override suspend fun getAlbums(): List<Album> {
        return FakeDataSource.albumList
    }

    override suspend fun getAlbum(id: String): Album {
        TODO("Not yet implemented")
    }

}