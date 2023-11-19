package com.miso2023equipo2.vinilos.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepositoryImpl
import com.miso2023equipo2.vinilos.data.repository.ArtistRepository
import com.miso2023equipo2.vinilos.data.repository.ArtistRepositoryImpl
import com.miso2023equipo2.vinilos.services.VinylsApiServiceAdapter
import com.miso2023equipo2.vinilos.services.VinylsApiServiceImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val albumsRepository: AlbumsRepository
    val artistRepository: ArtistRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://vinils-backend.onrender.com"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: VinylsApiServiceAdapter by lazy {
        retrofit.create(VinylsApiServiceImpl::class.java)

    }

    override val albumsRepository: AlbumsRepository by lazy {
        AlbumsRepositoryImpl(retrofitService)
    }
    override val artistRepository: ArtistRepository by lazy {
        ArtistRepositoryImpl(retrofitService)
    }

}