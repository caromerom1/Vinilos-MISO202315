package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository

class FakeNetworkAlbumsRepository: AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        return FakeDataSource.albumList
    }

    override suspend fun getAlbum(id: String): Album {
        TODO("Not yet implemented")
    }

}