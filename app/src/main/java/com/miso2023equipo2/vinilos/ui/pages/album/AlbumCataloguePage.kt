package com.miso2023equipo2.vinilos.ui.pages.album

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.ui.uistate.AlbumCatalogueUiState
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.ErrorScreen
import com.miso2023equipo2.vinilos.ui.components.ListItem
import com.miso2023equipo2.vinilos.ui.components.LoadingScreen
import com.miso2023equipo2.vinilos.ui.components.VinylsButton
import com.miso2023equipo2.vinilos.ui.components.VinylsList


@Composable
fun AlbumCataloguePage(albumCatalogueUiState: AlbumCatalogueUiState,
                       onBackButton:()->Unit={}, onDetailAlbumButton:()->Unit={}) {
    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("Album Catalogue Page", fontWeight = FontWeight.Bold)
        VinylsButton(
            onClick =  onBackButton ,
            label = stringResource(R.string.ejemplo)
        )
        when(albumCatalogueUiState){
            is AlbumCatalogueUiState.Loading->LoadingScreen(R.string.loading,modifier = Modifier.fillMaxSize())
            is AlbumCatalogueUiState.Success->{
                var listItem: MutableList<ListItem> = mutableListOf<ListItem>()
                albumCatalogueUiState.albums.forEach{album->
                    val listGen=ListItem(album.name,album.cover)
                    listItem.add(listGen)

                }
                VinylsList(items=listItem)
            }
            is AlbumCatalogueUiState.Error->ErrorScreen( R.string.loading_failed_albums,modifier = Modifier.fillMaxSize())
        }
        VinylsButton(
            type = ButtonType.SECONDARY,
            onClick = onDetailAlbumButton ,
            label = "Ver detalle de un álbum"
        )
    }
}



@Preview
@Composable
fun AlbumCataloguePagePreview() {
    val albumCatalogueViewModel: AlbumCatalogueViewModel = viewModel()
    AlbumCataloguePage(albumCatalogueViewModel._uiState)
}