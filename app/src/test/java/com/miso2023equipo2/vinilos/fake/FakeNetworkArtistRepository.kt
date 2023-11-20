package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.data.repository.ArtistRepository

class FakeNetworkArtistRepository: ArtistRepository {
    override suspend fun getArtists(): List<Artist> {
        return FakeDataSource.artistList
    }

    override suspend fun getArtist(id: String): Artist {
        TODO("Not yet implemented")
    }
}