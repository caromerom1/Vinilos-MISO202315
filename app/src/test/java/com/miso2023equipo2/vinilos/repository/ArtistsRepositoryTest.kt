package com.miso2023equipo2.vinilos.repository

import com.miso2023equipo2.vinilos.data.repository.ArtistRepositoryImpl
import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeVinylsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ArtistsRepositoryTest {
    @Test
    fun artistsRepository_getArtists() {
        runTest {
            val repository = ArtistRepositoryImpl(
                vinylsApiService = FakeVinylsApiService()
            )
            assertEquals(FakeDataSource.artistList, repository.getArtists())
        }

    }

    @Test
    fun artistsRepository_getArtist() {
        runTest {
            val repository = ArtistRepositoryImpl(
                vinylsApiService = FakeVinylsApiService()
            )
            assertEquals(FakeDataSource.artistList[2], repository.getArtist("3"))
        }
    }
}