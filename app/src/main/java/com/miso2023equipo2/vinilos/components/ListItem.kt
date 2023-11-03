package com.miso2023equipo2.vinilos.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewList() {
    val items = listOf(
        ListItem(text = "Item 1", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 2", imageUrl = "https://i1.sndcdn.com/artworks-140a538e-5e8f-4f3c-9de0-5627dcce04b6-0-t500x500.jpg"),
        ListItem(text = "Item 3", imageUrl = "https://hips.hearstapps.com/es.h-cdn.co/hares/images/cultura/ocio/portadas-de-discos-y-de-albums-de-musica-mas-importantes-del-s.xx/abbey-road-the-beatles-1969/4248779-1-esl-ES/abbey-road-the-beatles-1969.jpg?resize=980:*"),
        ListItem(text = "Item 4", imageUrl = "https://hips.hearstapps.com/es.h-cdn.co/hares/images/cultura/ocio/portadas-de-discos-y-de-albums-de-musica-mas-importantes-del-s.xx/the-dark-side-of-the-moon-pink-floyd-1973/4247827-1-esl-ES/the-dark-side-of-the-moon-pink-floyd-1973.jpg?resize=980:*"),
        ListItem(text = "Item 5", imageUrl = "https://i.pinimg.com/236x/74/a3/7d/74a37df699987b8bd8131d9dae350cd0.jpg"),
        ListItem(text = "Item 6", imageUrl = "https://cesarmiguelrondon.b-cdn.net/wp-content/uploads/2021/03/LUNES-08-Sonido-Bestial-Ricardo-Ray-Y-Bobby-Cruz.jpg"),
        ListItem(text = "Item 7", imageUrl = "https://musign.es/wp-content/uploads/2021/08/81SNg56GQhL._SL1425_-1-1024x1024.jpg?resize=980:*"),
        ListItem(text = "Item 8", imageUrl = "https://cdns-images.dzcdn.net/images/cover/ee45d13546b4fbaca08564ab45218de7/264x264.jpg"),
        ListItem(text = "Item 9", imageUrl = "https://cdns-images.dzcdn.net/images/cover/2b5c5649e9fe9a318a3c0bc49dbca9c3/264x264.jpg"),
        ListItem(text = "Item 10", imageUrl = "https://www.lahiguera.net/musicalia/artistas/bad_bunny/disco/10439/bad_bunny_yhlqmdlg-portada.jpg")
    )

    VinylsList(items = items)
}

data class ListItem ( val text: String,val imageUrl: String)

@Composable
fun VinylsList(items: List<ListItem>) {
    LazyColumn {
        items.forEach { item ->
            item {
                Item(text = item.text, imageUrl = item.imageUrl, onClick = {})
            }
        }
    }
}


