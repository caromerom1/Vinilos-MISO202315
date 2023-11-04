package com.miso2023equipo2.vinilos.pages.album

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.navigation.state.AlbumDetailUiState
import com.miso2023equipo2.vinilos.ui.components.ErrorScreen
import com.miso2023equipo2.vinilos.ui.components.LoadingScreen

@Composable
fun AlbumDetailPage(
    albumDetailUiState: AlbumDetailUiState,
) {
    Column(modifier = Modifier) {
        when (albumDetailUiState) {
            is AlbumDetailUiState.Loading -> LoadingScreen(
                R.string.loading,
                modifier = Modifier.fillMaxSize()
            )

            is AlbumDetailUiState.Success -> {
                val album = albumDetailUiState.album
                //TODO: Update this with Album detailed info
                Column {
                    Text(text = "Album ID: ${album.id}", fontWeight = FontWeight.Bold)
                    Text(text = "Album Name: ${album.name}", fontWeight = FontWeight.Bold)
                    Text(text = "Album Cover: ${album.cover}", fontWeight = FontWeight.Bold)
                    Text(
                        text = "Album Description: ${album.description}",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Album Genre: ${album.genre}", fontWeight = FontWeight.Bold)
                    Text(
                        text = "Album Release Date: ${album.releaseDate}",
                        fontWeight = FontWeight.Bold
                    )


                }
            }

            is AlbumDetailUiState.Error -> ErrorScreen(
                R.string.loading_failed_albums,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

//@Preview
//@Composable
//fun AlbumDetailPagePreview() {
//    val navController = rememberNavController()
//    AlbumDetailPage(navController = navController, albumId = 1)
//}
