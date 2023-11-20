package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.services.VinylsApiServiceAdapter

class CollectorRepositoryImpl(
    private val vinylsApiService: VinylsApiServiceAdapter
) : CollectorRepository {

    override suspend fun getCollectors(): List<Collector> {
        return vinylsApiService.getCollectors()
    }

    override suspend fun getCollector(id: String): Collector {
        return vinylsApiService.getCollector(id)
    }
}