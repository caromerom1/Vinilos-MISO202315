package com.miso2023equipo2.vinilos.repository

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
            assertEquals(FakeDataSource.albumList[0], repository.getAlbum("1"))
        }
    }
}