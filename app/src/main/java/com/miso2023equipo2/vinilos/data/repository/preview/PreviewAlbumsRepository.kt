package com.miso2023equipo2.vinilos.data.repository.preview

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository

class PreviewAlbumsRepository:AlbumsRepository {
    override suspend fun getAlbums(): List<Album> {
        val albumList = mutableListOf<Album>()
        for (i in 1..15) {
            val album = Album(
                id = i,
                name = "Album $i",
                cover = "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
                description = "Esta es la descripción fake del álbum $i",
                genre = "Metal",
                releaseDate = "1999-01-01"
            )
            albumList.add(album)
        }
        return albumList
    }

    override suspend fun getAlbum(id: String): Album {
        TODO("Not yet implemented")
    }
}