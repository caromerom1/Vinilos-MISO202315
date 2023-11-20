package com.miso2023equipo2.vinilos.data.repository

import com.miso2023equipo2.vinilos.data.model.Collector

interface CollectorRepository {
    suspend fun getCollectors(): List<Collector>
    suspend fun getCollector(id: String): Collector
}