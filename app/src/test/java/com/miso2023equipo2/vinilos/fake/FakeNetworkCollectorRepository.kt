package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.data.repository.CollectorRepository

class FakeNetworkCollectorRepository: CollectorRepository {
    override suspend fun getCollectors(): List<Collector> {
        return FakeDataSource.collectorList
    }

    override suspend fun getCollector(id: String): Collector {
        TODO("Not yet implemented")
    }

}