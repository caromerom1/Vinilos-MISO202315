package com.miso2023equipo2.vinilos.services

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.Artist

interface VinylsApiServiceAdapter {
    suspend fun getAlbums(): List<Album>;
    suspend fun getAlbum(id: String): Album;

    suspend fun getArtists(): List<Artist>;
    suspend fun getArtist(id: String): Artist;
}