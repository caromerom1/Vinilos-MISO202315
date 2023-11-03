package com.miso2023equipo2.vinilos.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.VinylsButton
import com.miso2023equipo2.vinilos.ui.navigation.AppPages



@Composable
fun AlbumCataloguePage(onBackButton:()->Unit={},onDetailAlbumButton:()->Unit={}) {
    Column(modifier = Modifier) {
        Spacer(modifier = Modifier.height(32.dp))
        Text("Album Catalogue Page", fontWeight = FontWeight.Bold)
        VinylsButton(
            onClick =  onBackButton ,
            label = "Volver a inicio"
        )
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

    AlbumCataloguePage()
}