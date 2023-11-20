package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.services.VinylsApiServiceImpl

class FakeVinylsApiService : VinylsApiServiceImpl {
    override suspend fun getAlbums(): List<Album> {
        return FakeDataSource.albumList
    }

    override suspend fun getAlbum(id: String): Album {
        val index = id.toInt() - 1
        if (index > 2 || index < 1) return FakeDataSource.albumList[0]
        return FakeDataSource.albumList[index]
    }

    override suspend fun getArtists(): List<Artist> {
        return FakeDataSource.artistList
    }

    override suspend fun getArtist(id: String): Artist {
        val index = id.toInt() - 1
        if (index > 2 || index < 1) return FakeDataSource.artistList[0]
        return FakeDataSource.artistList[index]
    }

    override suspend fun getCollectors(): List<Collector> {
        return FakeDataSource.collectorList
    }

    override suspend fun getCollector(id: String): Collector {
        val index = id.toInt() - 1
        if (index > 2 || index < 1) return FakeDataSource.collectorList[0]
        return FakeDataSource.collectorList[index]
    }

}