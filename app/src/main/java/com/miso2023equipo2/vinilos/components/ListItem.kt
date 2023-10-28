package com.miso2023equipo2.vinilos.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewList() {
    val items = listOf(
        ListItem(text = "Item 1", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 2", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 3", imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Bumblebee_%288023382295%29.jpg/1200px-Bumblebee_%288023382295%29.jpg"),
        ListItem(text = "Item 4", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 5", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 6", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 7", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 8", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 9", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg"),
        ListItem(text = "Item 10", imageUrl = "https://upload.wikimedia.org/wikipedia/en/b/b7/NirvanaNevermindalbumcover.jpg")
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


