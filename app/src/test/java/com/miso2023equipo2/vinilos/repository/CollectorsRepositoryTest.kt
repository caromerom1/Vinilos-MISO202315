package com.miso2023equipo2.vinilos.repository

import com.miso2023equipo2.vinilos.data.repository.CollectorRepositoryImpl
import com.miso2023equipo2.vinilos.fake.FakeDataSource
import com.miso2023equipo2.vinilos.fake.FakeVinylsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class CollectorsRepositoryTest {
    @Test
    fun collectorsRepository_getCollectors() {
        runTest {
            val repository = CollectorRepositoryImpl(
                vinylsApiService = FakeVinylsApiService()
            )
            assertEquals(FakeDataSource.collectorList, repository.getCollectors())
        }
    }

    @Test
    fun collectorsRepository_getCollector() {
        runTest {
            val repository = CollectorRepositoryImpl(
                vinylsApiService = FakeVinylsApiService()
            )
            assertEquals(FakeDataSource.collectorList[1], repository.getCollector("2"))
        }
    }
}