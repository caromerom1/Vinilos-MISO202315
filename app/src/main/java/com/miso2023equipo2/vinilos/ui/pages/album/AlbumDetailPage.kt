package com.miso2023equipo2.vinilos.ui.pages.album

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumDetailPage(navController: NavController, albumId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Detalle Álbum")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = Color.Black,
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }

                }
            )
        }
    ) {
        if (albumId == -1) {
            Text("Album ID not found", fontWeight = FontWeight.Bold)
            return@Scaffold
        }
        AlbumDetailBodyContent(navController = navController, albumId = albumId, padding = it)
    }
}

@Composable
fun AlbumDetailBodyContent(navController: NavController, albumId: Int, padding: PaddingValues) {
    Column(modifier = Modifier.padding(padding)) {
        Text("Album Detail Page", fontWeight = FontWeight.Bold)
        Text(text = "Album ID: $albumId", fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun AlbumDetailPagePreview() {
    val navController = rememberNavController()
    AlbumDetailPage(navController = navController, albumId = 1)
}
