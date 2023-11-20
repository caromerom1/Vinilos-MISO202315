package com.miso2023equipo2.vinilos.pages.artist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.Artist
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.DetailedList
import com.miso2023equipo2.vinilos.ui.components.ItemDetail
import com.miso2023equipo2.vinilos.ui.theme.Purple100

@Composable
fun ArtistDetailPage(
    artistDetailUiState: DataUiState<Artist>
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {
        DataFetchStates(
            uiState = artistDetailUiState,
            errorMessage = R.string.loading_failed_artist
        ) {
            if (artistDetailUiState !is DataUiState.Success) return@DataFetchStates

            val artist = artistDetailUiState.data

            val details = listOf(
                ItemDetail(stringResource(id = R.string.detail_album_label_name), artist.name),
                ItemDetail(
                    stringResource(id = R.string.detail_album_label_description),
                    artist.description
                ),
                ItemDetail(
                    stringResource(id = R.string.detail_artist_label_date),
                    artist.creationDate,
                    isDate = true
                ),

                )
            val albumDetails = artist.albums.map { album ->
                ItemDetail(album.cover, album.name, hasImage = true)
            }



            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
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
                DetailedList(details = details)
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = Purple100),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(),
                        text = stringResource(id = R.string.detail_artist_label_albums),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                DetailedList(details = albumDetails)
            }


        }
    }
}