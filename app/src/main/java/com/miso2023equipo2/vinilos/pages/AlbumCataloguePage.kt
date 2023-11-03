package com.miso2023equipo2.vinilos.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.miso2023equipo2.vinilos.ViewModel.AlbumCatalogueViewModel
import com.miso2023equipo2.vinilos.components.ButtonType
import com.miso2023equipo2.vinilos.components.VinylsButton
import com.miso2023equipo2.vinilos.navigation.AppPages
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.ViewModel.AlbumCatalogueUiState
import com.miso2023equipo2.vinilos.components.ErrorScreen
import com.miso2023equipo2.vinilos.components.ListItem
import com.miso2023equipo2.vinilos.components.LoadingScreen
import com.miso2023equipo2.vinilos.model.Album

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumCataloguePage(albumCatalogueUiState:AlbumCatalogueUiState,navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Álbumes")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = Color.Black,
                ),
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }

                }
            )
        }
    ) {
        AlbumCatalogueBodyContent(albumCatalogueUiState=albumCatalogueUiState,navController = navController, padding = it)
    }
}

@Composable
fun AlbumCatalogueBodyContent(albumCatalogueUiState:AlbumCatalogueUiState,navController: NavController, padding: PaddingValues) {
    Column(modifier = Modifier.padding(padding)) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("Album Catalogue Page", fontWeight = FontWeight.Bold)
        VinylsButton(
            onClick = { navController.popBackStack() },
            label = "Volver a inicio"
        )
        when(albumCatalogueUiState){
            is AlbumCatalogueUiState.Loading->LoadingScreen(R.string.loading,modifier = Modifier.fillMaxSize())
            is AlbumCatalogueUiState.Success->Text(albumCatalogueUiState.albums)
            is AlbumCatalogueUiState.Error->ErrorScreen( R.string.loading_failed_albums,modifier = Modifier.fillMaxSize())
        }
        VinylsButton(
            type = ButtonType.SECONDARY,
            onClick = { navController.navigate(route = AppPages.AlbumDetailPage.route + "/123") },
            label = "Ver detalle de un álbum"
        )
    }
}
/*fun ListAlbumToListItem(listAlbum:List<Album>):ListItem{

    
}*/
@Preview
@Composable
fun AlbumCataloguePagePreview() {
    val navController = rememberNavController()
    val albumCatalogueViewModel:AlbumCatalogueViewModel=viewModel()
    AlbumCataloguePage(albumCatalogueUiState=albumCatalogueViewModel.albumCatalogueUiState,navController = navController)
}