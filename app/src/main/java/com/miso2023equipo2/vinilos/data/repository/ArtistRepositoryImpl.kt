package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.services.VinylsApiServiceAdapter

class ArtistRepositoryImpl(
    private val vinylsApiService: VinylsApiServiceAdapter
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist> {
        return vinylsApiService.getArtists()
    }

    override suspend fun getArtist(id: String): Artist {
        return vinylsApiService.getArtist(id)
    }

}