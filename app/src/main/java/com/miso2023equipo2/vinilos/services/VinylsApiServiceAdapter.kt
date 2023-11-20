package com.miso2023equipo2.vinilos.services

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.data.model.Collector

interface VinylsApiServiceAdapter {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(id: String): Album

    suspend fun getArtists(): List<Artist>
    suspend fun getArtist(id: String): Artist

    suspend fun getCollectors(): List<Collector>
    suspend fun getCollector(id: String): Collector
}