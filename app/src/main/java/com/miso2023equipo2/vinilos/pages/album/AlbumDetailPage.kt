package com.miso2023equipo2.vinilos.pages.album

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.data.model.AlbumDetail
import com.miso2023equipo2.vinilos.data.model.CommentCreate
import com.miso2023equipo2.vinilos.data.model.CommentCreateCollector
import com.miso2023equipo2.vinilos.navigation.User
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import com.miso2023equipo2.vinilos.ui.components.ButtonType
import com.miso2023equipo2.vinilos.ui.components.DataFetchStates
import com.miso2023equipo2.vinilos.ui.components.DetailedList
import com.miso2023equipo2.vinilos.ui.components.DropdownSelector
import com.miso2023equipo2.vinilos.ui.components.ItemDetail
import com.miso2023equipo2.vinilos.ui.components.VinylsButton

@Composable
fun AlbumDetailPage(
    user: User?,
    albumDetailViewModel: AlbumDetailViewModel,
    commentViewModel: CommentViewModel,
    albumId: String,
    navController: NavController
) {

    val albumDetailUiState = albumDetailViewModel.uiState

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {
        DataFetchStates(
            uiState = albumDetailUiState,
            errorMessage = R.string.loading_failed_album
        ) {
            AlbumDetails(albumDetailUiState = albumDetailUiState)

            CommentsHeader()

            Spacer(modifier = Modifier.height(10.dp))

            CommentsSection(albumDetailUiState = albumDetailUiState)

            if (user?.role != User.Collector.role) return@DataFetchStates

            AlbumComment(
                albumId = albumId,
                albumDetailViewModel = albumDetailViewModel,
                commentViewModel = commentViewModel,
                navController = navController
            )
        }
    }
}

@Composable
fun AlbumDetails(albumDetailUiState: DataUiState<AlbumDetail>) {
    if (albumDetailUiState !is DataUiState.Success) return
    val album = albumDetailUiState.data

    val details = listOf(
        ItemDetail(stringResource(id = R.string.detail_label_name), album.name),
        ItemDetail(
            stringResource(id = R.string.detail_album_label_description),
            album.description
        ),
        ItemDetail(
            stringResource(id = R.string.detail_album_label_date),
            album.releaseDate,
            isDate = true
        ),
        ItemDetail(stringResource(id = R.string.detail_album_label_genre), album.genre),
    )


    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
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
        DetailedList(details = details)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun CommentsHeader() {
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
            text = stringResource(id = R.string.detail_album_label_comments),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun CommentsSection(albumDetailUiState: DataUiState<AlbumDetail>) {

    if (albumDetailUiState !is DataUiState.Success) return
    val comments = albumDetailUiState.data.comments

    Spacer(modifier = Modifier.height(10.dp))
    comments.forEach {
        val stars = "⭐".repeat(it.rating)

        Text(
            modifier = Modifier.padding(),
            text = "${it.description} $stars️",
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun AlbumComment(
    albumId: String,
    albumDetailViewModel: AlbumDetailViewModel,
    commentViewModel: CommentViewModel,
    navController: NavController
) {
    val (description, rating) = commentViewModel.formState

    if (commentViewModel.commentUiState is DataUiState.Success) {
        description.value = ""
        rating.value = ""

        commentViewModel.commentUiState = DataUiState.Loading

        albumDetailViewModel.getAlbum(id = albumId)
    }

    Column(horizontalAlignment = Alignment.End) {
        DropdownSelector(
            value = rating.value,
            placeholder = R.string.create_comment_rating_placeholder,
            options = listOf(
                "⭐".repeat(5),
                "⭐".repeat(4),
                "⭐".repeat(3),
                "⭐".repeat(2),
                "⭐".repeat(1),
            ),
            onValueChange = {
                rating.value = it
            }
        )

        OutlinedTextField(
            value = description.value,
            placeholder = { Text(stringResource(id = R.string.create_album_description_placeholder)) },
            onValueChange = { newText -> description.value = newText },
            singleLine = false,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            label = { Text(stringResource(id = R.string.create_album_description)) },
            isError = false,
        )

        Spacer(modifier = Modifier.height(10.dp))

        VinylsButton(
            type = ButtonType.ALTERNATIVE,
            label = stringResource(id = R.string.comment_button_label),
            onClick = {
                commentViewModel.commentAlbum(
                    albumId = albumId,
                    comment = CommentCreate(
                        description = description.value,
                        collector = CommentCreateCollector(
                            id = 1,
                        ),
                        rating = rating.value.length,
                    ),
                    navController = navController
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
    }
}