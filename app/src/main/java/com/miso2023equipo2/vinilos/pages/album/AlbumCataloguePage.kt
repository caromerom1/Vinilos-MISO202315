package com.miso2023equipo2.vinilos.pages.album

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.navigation.User
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.EmptyItemsScreen
import com.miso2023equipo2.vinilos.ui.components.ListItem
import com.miso2023equipo2.vinilos.ui.components.VinylsButton
import com.miso2023equipo2.vinilos.ui.components.VinylsList


@Composable
fun AlbumCataloguePage(
    user: User?,
    albumCatalogueUiState: DataUiState<List<Album>>,
    onDetailAlbumButton: (id: String) -> Unit = {},
    onCreateAlbumButton: () -> Unit = {}
) {
    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.height(16.dp))
        DataFetchStates(
            uiState = albumCatalogueUiState,
            errorMessage = R.string.loading_failed_albums
        ) {
            if (albumCatalogueUiState !is DataUiState.Success) return@DataFetchStates

            if (albumCatalogueUiState.data.isEmpty()) {
                EmptyItemsScreen(message = R.string.albums_not_found)
                return@DataFetchStates
            }

            val listItem: MutableList<ListItem> = mutableListOf()
            albumCatalogueUiState.data.forEach { album ->
                val listGen =
                    ListItem(text = album.name, imageUrl = album.cover, id = "${album.id}")
                listItem.add(listGen)

            }
            Column(
                verticalArrangement = Arrangement.spacedBy((-62).dp),
            ) {

                Box {
                    VinylsList(listItems = listItem, onClickItem = onDetailAlbumButton)
                }

                if (user?.role != User.Collector.role) {
                    return@DataFetchStates
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.End)

                ) {
                    Column {
                        Row {
                            VinylsButton(
                                icon = Icons.Outlined.Add,
                                onClick = onCreateAlbumButton,
                                type = ButtonType.PRIMARY,
                                modifier = Modifier
                                    .width(48.dp)
                                    .height(48.dp)
                            )
                            Spacer(
                                modifier = Modifier
                                    .width(32.dp)
                            )
                        }
                    }
                }

            }

        }

    }


}