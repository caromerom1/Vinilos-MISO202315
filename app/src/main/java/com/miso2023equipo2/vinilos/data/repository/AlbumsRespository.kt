package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.data.model.Comment
import com.miso2023equipo2.vinilos.data.model.CommentCreate

interface AlbumsRepository {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(id: String): Album
    suspend fun createAlbum(album: AlbumCreate): AlbumCreate
    suspend fun commentAlbum(id: String, comment: CommentCreate): Comment
}

