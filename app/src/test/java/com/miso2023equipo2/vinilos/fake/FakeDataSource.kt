package com.miso2023equipo2.vinilos.fake

import com.miso2023equipo2.vinilos.data.model.Album

object FakeDataSource {
    val albumList= listOf<Album>(
        Album(1,
            "Album 1",
            "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            "Esta es la descripcion fake del album",
            "Metal",
            "1999-01-01"),
        Album(2,
            "Album 2",
            "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            "Esta es la descripcion fake del album",
            "Metal",
            "1999-01-01"),
        Album(3,
            "Album 3",
            "https://www.udiscovermusic.com/wp-content/uploads/2017/03/Metallica-Ride-The-Lightning-album-cover-web-optimised-820.jpg",
            "Esta es la descripcion fake del album",
            "Metal",
            "1999-01-01"),
    )
}