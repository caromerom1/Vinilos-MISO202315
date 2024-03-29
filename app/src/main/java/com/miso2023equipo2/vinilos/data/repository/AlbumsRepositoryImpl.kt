package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.data.model.AlbumDetail
import com.miso2023equipo2.vinilos.data.model.Comment
import com.miso2023equipo2.vinilos.data.model.CommentCreate
import com.miso2023equipo2.vinilos.services.VinylsApiServiceAdapter

class AlbumsRepositoryImpl(
    private val vinylsApiService: VinylsApiServiceAdapter
) : AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        return vinylsApiService.getAlbums()
    }

    override suspend fun getAlbum(id: String): AlbumDetail {
        return vinylsApiService.getAlbum(id)
    }

    override suspend fun createAlbum(album: AlbumCreate): AlbumCreate {
        return vinylsApiService.createAlbum(album)
    }

    override suspend fun commentAlbum(id: String, comment: CommentCreate): Comment {
        return vinylsApiService.commentAlbum(id, comment)
    }
}