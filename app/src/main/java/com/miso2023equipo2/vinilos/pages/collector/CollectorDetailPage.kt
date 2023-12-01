package com.miso2023equipo2.vinilos.pages.collector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.Album
import com.miso2023equipo2.vinilos.data.model.Collector
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.DetailedList
import com.miso2023equipo2.vinilos.ui.components.ItemDetail

@Composable
fun CollectorDetailPage(
    uiState: DataUiState<Pair<Collector, List<Album>>>
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {
        DataFetchStates(
            uiState = uiState,
            errorMessage = R.string.loading_failed_collector
        ) {
            if (uiState !is DataUiState.Success) return@DataFetchStates

            val (collector, collectorAlbums) = uiState.data

            val albumDetails = collectorAlbums.map { album ->
                ItemDetail(album.cover, album.name, hasImage = true)
            }

            val artistDetails = collector.favoritePerformers.map { artist ->
                ItemDetail(artist.image, artist.name, hasImage = true)
            }


            val details: List<ItemDetail> = listOf(
                ItemDetail(stringResource(id = R.string.detail_label_name), collector.name),
                ItemDetail(
                    stringResource(id = R.string.detail_label_phone),
                    collector.phone
                ),
                ItemDetail(
                    stringResource(id = R.string.detail_label_email),
                    collector.email
                ),
            )


            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vinyl),
                        contentDescription = "Coleccionista ${collector.name}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(64.dp)

                    )
                }
                DetailedList(details = details)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = MaterialTheme.colorScheme.outlineVariant),
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(color = MaterialTheme.colorScheme.outlineVariant),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(),
                    text = stringResource(id = R.string.detail_artist_label_artists),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            DetailedList(details = artistDetails)
        }

    }
}