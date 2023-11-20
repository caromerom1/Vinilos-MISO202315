package com.miso2023equipo2.vinilos.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

data class ListItem(val id: String, val text: String, val imageUrl: String)

@Composable
fun VinylsList(onClickItem: (id: String) -> Unit, listItems: List<ListItem>) {
    LazyColumn {
        items(listItems) { item ->
            Item(text = item.text, imageUrl = item.imageUrl, onClick = { onClickItem(item.id) })
        }
    }
}


