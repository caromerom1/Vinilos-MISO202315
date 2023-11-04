package com.miso2023equipo2.vinilos.services

import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.miso2023equipo2.vinilos.data.model.Album
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL =
    "https://vinils-backend.onrender.com"

private val json = Json {
    ignoreUnknownKeys = true
}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface VinylsApiService {
    @GET("/albums")
    suspend fun getAlbums(): List<Album>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id") id: String): Album
}

object VinylsApi {
    val retrofitService: VinylsApiService by lazy {
        retrofit.create(VinylsApiService::class.java)
    }
}