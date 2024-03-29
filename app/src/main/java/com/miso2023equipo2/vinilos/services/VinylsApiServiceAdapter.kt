package com.miso2023equipo2.vinilos.services

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.AlbumCreate
import com.miso2023equipo2.vinilos.data.model.AlbumDetail
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.data.model.Comment
import com.miso2023equipo2.vinilos.data.model.CommentCreate

interface VinylsApiServiceAdapter {
    suspend fun getAlbums(): List<Album>
    suspend fun getAlbum(id: String): AlbumDetail
    suspend fun createAlbum(album: AlbumCreate): AlbumCreate
    suspend fun commentAlbum(id: String, comment: CommentCreate): Comment

    suspend fun getArtists(): List<Artist>
    suspend fun getArtist(id: String): Artist

    suspend fun getCollectors(): List<Collector>
    suspend fun getCollector(id: String): Collector
}