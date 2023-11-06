package com.miso2023equipo2.vinilos

import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepositoryImpl
import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeVinylsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals
class NetworkVinylsRepositoryTest {
    /** Prueba de sobre  los view Model**/
    @Test
    fun networkVinylsRepository_getAlbums_verifyAlbumList(){
        runTest{
            val repository=AlbumsRepositoryImpl(
                vinylsApiService=FakeVinylsApiService()
            )
            assertEquals(FakeDataSource.albumList,repository.getAlbums())
        }

    }
    @Test
    fun networkVinylsRepository_getAlbum_verifyAlbum(){
        runTest{
            val repository=AlbumsRepositoryImpl(
                vinylsApiService=FakeVinylsApiService()
            )
            assertEquals(FakeDataSource.albumList[0],repository.getAlbum("1"))
        }
    }
}