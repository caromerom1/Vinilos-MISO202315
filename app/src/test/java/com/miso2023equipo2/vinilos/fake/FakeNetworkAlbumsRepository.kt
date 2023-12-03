package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.data.model.AlbumDetail
import com.miso2023equipo2.vinilos.data.model.Comment
import com.miso2023equipo2.vinilos.data.model.CommentCreate
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository

class FakeNetworkAlbumsRepository: AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        return FakeDataSource.albumList
    }

    override suspend fun getAlbum(id: String): AlbumDetail {
        TODO("Not yet implemented")
    }

    override suspend fun createAlbum(album: AlbumCreate): AlbumCreate {
        TODO("Not yet implemented")
    }

    override suspend fun commentAlbum(id: String, comment: CommentCreate): Comment {
        TODO("Not yet implemented")
    }

}