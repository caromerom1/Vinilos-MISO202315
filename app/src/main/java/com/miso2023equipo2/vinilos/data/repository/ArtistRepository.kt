package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>
    suspend fun getArtist(id:String):Artist
}