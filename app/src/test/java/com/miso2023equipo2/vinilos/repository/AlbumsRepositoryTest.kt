package com.miso2023equipo2.vinilos.repository

import com.miso2023equipo2.vinilos.data.model.AlbumDetail
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepositoryImpl
import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeVinylsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AlbumsRepositoryTest {
    @Test
    fun albumsRepository_getAlbums() {
        runTest {
            val repository = AlbumsRepositoryImpl(
                vinylsApiService = FakeVinylsApiService()
            )
            assertEquals(FakeDataSource.albumList, repository.getAlbums())
        }

    }

    @Test
    fun albumsRepository_getAlbum() {
        runTest {
            val repository = AlbumsRepositoryImpl(
                vinylsApiService = FakeVinylsApiService()
            )

            val album = FakeDataSource.albumList[0]

            val albumDetail = AlbumDetail(
                id = album.id,
                name = album.name,
                cover = album.cover,
                description = album.description,
                genre = album.genre,
                releaseDate = album.releaseDate,
                recordLabel = album.recordLabel,
                comments = listOf()
            )
            assertEquals(albumDetail, repository.getAlbum("1"))
        }
    }
}