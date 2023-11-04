package com.miso2023equipo2.vinilos.pages.album

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.navigation.state.AlbumCatalogueUiState
import com.miso2023equipo2.vinilos.ui.components.ErrorScreen
import com.miso2023equipo2.vinilos.ui.components.ListItem
import com.miso2023equipo2.vinilos.ui.components.LoadingScreen
import com.miso2023equipo2.vinilos.ui.components.VinylsButton
import com.miso2023equipo2.vinilos.ui.components.VinylsList


@Composable
fun AlbumCataloguePage(
    albumCatalogueUiState: AlbumCatalogueUiState,
    onBackButton: () -> Unit, onDetailAlbumButton: (id: String) -> Unit
) {
    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.height(32.dp))
        //TODO: Remove this button
        VinylsButton(
            onClick = onBackButton,
            label = stringResource(R.string.ejemplo)
        )
        when (albumCatalogueUiState) {
            is AlbumCatalogueUiState.Loading -> LoadingScreen(
                R.string.loading,
                modifier = Modifier.fillMaxSize()
            )

            is AlbumCatalogueUiState.Success -> {
                val listItem: MutableList<ListItem> = mutableListOf()
                albumCatalogueUiState.albums.forEach { album ->
                    val listGen =
                        ListItem(text = album.name, imageUrl = album.cover, id = "${album.id}")
                    listItem.add(listGen)

                }
                VinylsList(listItems = listItem, onClickItem = onDetailAlbumButton)
            }

            is AlbumCatalogueUiState.Error -> ErrorScreen(
                R.string.loading_failed_albums,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Preview
@Composable
fun AlbumCataloguePagePreview() {
    val albumCatalogueViewModel: AlbumCatalogueViewModel = viewModel()
    AlbumCataloguePage(albumCatalogueViewModel.uiState, {}, {})
}