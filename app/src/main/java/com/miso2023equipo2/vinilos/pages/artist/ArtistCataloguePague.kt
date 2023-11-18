package com.miso2023equipo2.vinilos.pages.artist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.ListItem
import com.miso2023equipo2.vinilos.ui.components.VinylsList

@Composable
fun ArtistCataloguePage(
    albumCatalogueUiState: DataUiState<List<Album>>,
    onDetailAlbumButton: (id: String) -> Unit
) {
    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.height(16.dp))
        DataFetchStates(
            uiState = albumCatalogueUiState,
            errorMessage = R.string.loading_failed_albums
        ) {
            if (albumCatalogueUiState !is DataUiState.Success) return@DataFetchStates

            val listItem: MutableList<ListItem> = mutableListOf()
            albumCatalogueUiState.data.forEach { album ->
                val listGen =
                    ListItem(text = album.name, imageUrl = album.cover, id = "${album.id}")
                listItem.add(listGen)

            }
            VinylsList(listItems = listItem, onClickItem = onDetailAlbumButton)
        }
    }
}
