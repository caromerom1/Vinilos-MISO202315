package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.services.VinylsApiService

class FakeVinylsApiService:VinylsApiService{
    override suspend fun getAlbums(): List<Album> {
        return FakeDataSource.albumList
    }

    override suspend fun getAlbum(id: String): Album {
        val foundAlbum=FakeDataSource.albumList.find{it.id==id.toInt()}
        return foundAlbum!!
    }

}