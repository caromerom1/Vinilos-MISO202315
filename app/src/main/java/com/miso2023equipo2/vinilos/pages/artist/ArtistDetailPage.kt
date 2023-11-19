package com.miso2023equipo2.vinilos.pages.artist

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.DetailedList
import com.miso2023equipo2.vinilos.ui.components.ItemDetail

@Composable
fun ArtistDetailPage(
    artisDetailUiState:DataUiState<Artist>
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {
        DataFetchStates(uiState = artisDetailUiState, errorMessage = R.string.loading_failed_album) {
            if (artisDetailUiState !is DataUiState.Success) return@DataFetchStates

            val artist = artisDetailUiState.data

            val details = listOf(
                ItemDetail(stringResource(id = R.string.detail_album_label_name ), artist.name),
                ItemDetail(stringResource(id = R.string.detail_album_label_description ), artist.description),
                ItemDetail(stringResource(id = R.string.detail_artist_label_date ), artist.creationDate, isDate = true),
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
                        model = artist.cover,
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