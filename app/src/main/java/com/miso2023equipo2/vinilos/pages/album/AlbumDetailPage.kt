package com.miso2023equipo2.vinilos.pages.album

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.navigation.state.AlbumDetailUiState
import com.miso2023equipo2.vinilos.ui.components.ErrorScreen
import com.miso2023equipo2.vinilos.ui.components.LoadingScreen
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@Composable
fun AlbumDetailPage(
    albumDetailUiState: AlbumDetailUiState
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {
        when (albumDetailUiState) {
            is AlbumDetailUiState.Loading -> LoadingScreen(
                R.string.loading,
                modifier = Modifier.fillMaxSize()
            )

            is AlbumDetailUiState.Success -> {
                val album = albumDetailUiState.album



                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Box(
                        modifier = Modifier
                            .size(200.dp, 200.dp)
                    ) {
                        AsyncImage(
                            model = album.cover,
                            placeholder = painterResource(id = R.drawable.vinyl),
                            error = painterResource(id = R.drawable.vinyl),
                            contentDescription = "Vinyls Logo",
                            modifier = Modifier
                                .padding(28.dp)
                                .size(160.dp)
                        )
                    }
                }

                Column {
                    Row {
                        Text(
                            text = "Nombre", fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .width(130.dp)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        Text(
                            text = album.name, modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                    Row {
                        Text(
                            text = "Descripción", fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .width(130.dp)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        Text(
                            text = album.description, modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                    val formattedDate =
                        ZonedDateTime.parse(album.releaseDate, DateTimeFormatter.ISO_DATE_TIME)
                            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    Row {
                        Text(
                            text = "Fecha de \nlanzamiento", fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .width(130.dp)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        Text(
                            text = formattedDate.toString(),
                            modifier = Modifier
                                .width(130.dp)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                    Row {
                        Text(
                            text = "Género", fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .width(130.dp)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        Text(
                            text = album.genre, modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                }

//
            }

            is AlbumDetailUiState.Error -> ErrorScreen(
                R.string.loading_failed_albums,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
