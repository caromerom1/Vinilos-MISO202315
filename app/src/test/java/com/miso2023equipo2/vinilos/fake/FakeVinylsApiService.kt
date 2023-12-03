package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.data.model.AlbumDetail
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.data.model.Comment
import com.miso2023equipo2.vinilos.data.model.CommentCreate
import com.miso2023equipo2.vinilos.services.VinylsApiServiceAdapter

class FakeVinylsApiService : VinylsApiServiceAdapter {
    override suspend fun getAlbums(): List<Album> {
        return FakeDataSource.albumList
    }

    override suspend fun getAlbum(id: String): AlbumDetail {
        val index = id.toInt() - 1
        if (index > 2 || index < 1) {
            val album = FakeDataSource.albumList[0]
            return AlbumDetail(
                id = album.id,
                name = album.name,
                cover = album.cover,
                description = album.description,
                genre = album.genre,
                releaseDate = album.releaseDate,
                recordLabel = album.recordLabel,
                comments = listOf()
            )
        }
        val album = FakeDataSource.albumList[index]
        return AlbumDetail(
            id = album.id,
            name = album.name,
            cover = album.cover,
            description = album.description,
            genre = album.genre,
            releaseDate = album.releaseDate,
            recordLabel = album.recordLabel,
            comments = listOf()
        )
    }

    override suspend fun createAlbum(album: AlbumCreate): AlbumCreate {
        TODO("Not yet implemented")
    }

    override suspend fun commentAlbum(id: String, comment: CommentCreate): Comment {
        TODO("Not yet implemented")
    }

    override suspend fun getArtists(): List<Artist> {
        return FakeDataSource.artistList
    }

    override suspend fun getArtist(id: String): Artist {
        val index = id.toInt() - 1
        if (index > 2 || index < 1) return FakeDataSource.artistList[0]
        return FakeDataSource.artistList[index]
    }

    override suspend fun getCollectors(): List<Collector> {
        return FakeDataSource.collectorList
    }

    override suspend fun getCollector(id: String): Collector {
        val index = id.toInt() - 1
        if (index > 2 || index < 1) return FakeDataSource.collectorList[0]
        return FakeDataSource.collectorList[index]
    }
}