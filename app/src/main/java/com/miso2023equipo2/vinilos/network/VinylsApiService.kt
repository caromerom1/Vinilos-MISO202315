package com.miso2023equipo2.vinilos.network

import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.miso2023equipo2.vinilos.model.Album
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.GET

private const val BASE_URL =
    "http://127.0.0.1:3000/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()
    interface VinylsApiService{
        @GET("albums")
        suspend fun getAlbums():List<Album>
    }

object VinylsApi {
    val retrofitService : VinylsApiService by lazy {
        retrofit.create(VinylsApiService::class.java)
    }
}