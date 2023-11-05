package com.miso2023equipo2.vinilos.pages.album

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.DetailedList
import com.miso2023equipo2.vinilos.ui.components.ItemDetail


@Composable
fun AlbumDetailPage(
    albumDetailUiState: DataUiState<Album>
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {
        DataFetchStates(uiState = albumDetailUiState, errorMessage = R.string.loading_failed_album) {
            if (albumDetailUiState !is DataUiState.Success) return@DataFetchStates

            val album = albumDetailUiState.data

            val details = listOf(
                ItemDetail("Nombre", album.name),
                ItemDetail("Descripción", album.description),
                ItemDetail("Fecha de lanzamiento", album.releaseDate, isDate = true),
                ItemDetail("Género", album.genre),
            )


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
            DetailedList(details = details)
        }
    }
}