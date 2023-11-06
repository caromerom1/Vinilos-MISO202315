package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Album

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(id: String): Album
}

