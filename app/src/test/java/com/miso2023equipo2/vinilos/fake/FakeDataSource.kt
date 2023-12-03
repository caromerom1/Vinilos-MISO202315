package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.data.model.Collector

object FakeDataSource {
    val albumList = listOf(
        Album(
            1,
            "Album 1",
            "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            "Esta es la description fake del album",
            "Metal",
            "1999-01-01",
            "Sony Music"
        ),
        Album(
            2,
            "Album 2",
            "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            "Esta es la description fake del album",
            "Metal",
            "1999-01-01",
            "Sony Music"
        ),
        Album(
            3,
            "Album 3",
            "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            "Esta es la description fake del album",
            "Metal",
            "1999-01-01",
            "Sony Music"
        ),
    )

    val artistList = listOf(
        Artist(
            id = 1,
            name = "Metallica",
            description = "Esta es la description fake del artista",
            cover = "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            albums = listOf(),
            creationDate = "1999-01-01",
        ),
        Artist(
            id = 2,
            name = "Metallica",
            description = "Esta es la description fake del artista",
            cover = "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            albums = listOf(),
            creationDate = "1999-01-01",
        ),
        Artist(
            id = 3,
            name = "Metallica",
            description = "Esta es la description fake del artista",
            cover = "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            albums = listOf(),
            creationDate = "1999-01-01",
        ),
    )

    val collectorList = listOf(
        Collector(
            id = 1,
            name = "Juan",
            phone = "123456789",
            email = "test@test.com",
            collectorAlbums = emptyList(),
            favoritePerformers = emptyList(),
        ),
        Collector(
            id = 2,
            name = "Alimaña",
            phone = "987654321",
            email = "test2@test.com",
            collectorAlbums = emptyList(),
            favoritePerformers = emptyList(),
        ),
        Collector(
            id = 3,
            name = "Juanito",
            phone = "123123123",
            email = "test3@test.com",
            collectorAlbums = emptyList(),
            favoritePerformers = emptyList(),
        ),
    )
}